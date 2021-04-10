package com.example.kmm_recyclerview.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kmm_recyclerview.Greeting
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kmm_recyclerview.GdgLogger
import com.example.kmm_recyclerview.models.ResModelData
import com.example.kmm_recyclerview.repositorys.RestaurantRespository
import kotlinx.coroutines.launch

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.simpleName ?: ""
    private val restaurantRespository = RestaurantRespository()
    private lateinit var recyclerView: RecyclerView

    private val rssAdapter = MyAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        GdgLogger.d("MainAAA", "HELLO")

        recyclerView.adapter = rssAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            kotlin.runCatching {
                restaurantRespository.getRestaurants()
            }.onSuccess {
                resModel ->
                rssAdapter.feeds = resModel.data
                rssAdapter.notifyDataSetChanged()
                GdgLogger.i("HIHIHIHI", resModel.data.toString())
            }.onFailure {
                GdgLogger.e(TAG, it.toString())
            }
        }
    }
}
