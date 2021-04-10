package com.example.kmm_recyclerview.repositorys.apis

import com.example.kmm_recyclerview.GdgLogger
import com.example.kmm_recyclerview.models.ResModel
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.utils.io.core.internal.*

class RestaurantApi {
    // 建立 companion 的區塊 類似 static 但又不是很像
    // 要呼叫的時候就這樣寫 RestaurantApi.companion.RESTAURANT_API
    companion object {
        private const val RESTAURANT_API =
            "https://virtserver.swaggerhub.com/moontai0724/cmrdb-6th-hackathon/0.1.0/restaurants"
    }
    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
                coerceInputValues = true
                isLenient = true
            }

            serializer = KotlinxSerializer(json)
            GdgLogger.d("CCC",serializer.toString())
        }
    }
    suspend fun getRestaurantData(): ResModel {
        val endpoint = "$RESTAURANT_API"
        return httpClient.get(endpoint)
    }
}