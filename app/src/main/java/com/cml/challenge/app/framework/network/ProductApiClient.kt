package com.cml.challenge.app.framework.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApiClient {
    @GET("/sites/MLM/search?")
    suspend fun searchItems(
        @Query("q") textSearch: String
    ): Response<APIResponseProducts>

    @GET("/items?")
    suspend fun getItem(
        @Query("ids") idItem: String
    ): Response<List<APIResponseDetailProduct>>
}