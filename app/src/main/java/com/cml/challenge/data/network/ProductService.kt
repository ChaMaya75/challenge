package com.cml.challenge.data.network

import android.util.Log
import com.cml.challenge.core.RetrofitHelper
import com.cml.challenge.data.model.ProductModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getProducts(query: String): APIResponseSearch? {
        return withContext(Dispatchers.IO) {
            val response: Response<APIResponseSearch> =
                retrofit.create(ProductApiClient::class.java).searchItems(query)
                Log.i("***","getProducts")
                response.body()
        }
    }
    suspend fun getDetail(query:String): APIResponseProduct?{
        return withContext(Dispatchers.IO) {
            val response: Response<APIResponseProduct> =
                    retrofit.create(ProductApiClient::class.java).getItem(query)
            Log.i("***","getDetail")
            response.body()
        }
    }
}