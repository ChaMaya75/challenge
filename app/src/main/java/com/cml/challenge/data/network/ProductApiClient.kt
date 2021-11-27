package com.cml.challenge.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApiClient {
    @GET("/sites/MLM/search?")
    suspend fun searchItems(
        @Query("q") textSearch: String
    ): Response<APIResponseSearch>

    @GET("/items?")
    suspend fun getItem(
        @Query("ids") idItem: String
    ): List<APIResponseProduct>
}