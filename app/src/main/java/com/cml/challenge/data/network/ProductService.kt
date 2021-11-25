package com.cml.challenge.data.network

import com.cml.challenge.core.RetrofitHelper
import com.cml.challenge.data.model.ProductModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getProducts() {
        return withContext(Dispatchers.IO) {
            val response: APIResponseSearch =
                retrofit.create(ProductApiClient::class.java).searchItems("xbox")
        }
    }
}