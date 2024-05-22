package com.kaspersky.data.network

import com.kaspersky.data.network.model.AllInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiSkyEnd {
    @GET("/api/public/v1/words/search")
    suspend fun getWord(@Query("search") word: String): List<AllInfo>
}