package com.cml.challenge.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApiClient {
    @GET("/sites/MLA/search?")
    suspend fun searchItems(
        @Query("q") textSearch: String
    ): APIResponseSearch

    @GET("/items?")
    suspend fun getItem(
        @Query("ids") idItem: String
    ): List<APIResponseProduct>
}