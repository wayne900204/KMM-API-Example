package com.example.kmm_recyclerview.repositorys

import com.example.kmm_recyclerview.GdgLogger
import com.example.kmm_recyclerview.models.ResModel
import com.example.kmm_recyclerview.repositorys.apis.RestaurantApi

class RestaurantRespository {
    private val api = RestaurantApi()

    companion object {
        internal val TAG = RestaurantRespository::class.simpleName ?: ""
    }
    suspend fun getRestaurants(): ResModel {
        api.getRestaurantData().also {
            GdgLogger.i("ABCCC", it.toString())
            return it
        }
    }
}