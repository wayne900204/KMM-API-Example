package com.example.kmm_recyclerview.android

import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kmm_recyclerview.models.ResModel
import com.example.kmm_recyclerview.models.ResModelData
import android.graphics.drawable.BitmapDrawable

import android.graphics.Bitmap
import java.net.URL







class MyAdapter(var feeds: List<ResModelData>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_itme_style, parent, false)
            .run(::MyViewHolder)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(feeds[position])
    }

    override fun getItemCount() = feeds.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView = itemView.findViewById<TextView>(R.id.name)
        private val restaurantImage = itemView.findViewById<ImageView>(R.id.restaurant_image)
        private val description = itemView.findViewById<TextView>(R.id.description)
        private val address = itemView.findViewById<TextView>(R.id.address)
        fun bindView(item: ResModelData) {
            restaurantImage.setImageResource(R.drawable.food)
            nameTextView.text = item.name
            description.text = item.description
            address.text = item.address
        }
    }
}