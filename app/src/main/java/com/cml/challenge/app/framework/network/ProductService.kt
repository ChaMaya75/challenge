package com.cml.challenge.app.framework.network

import android.util.Log
import com.cml.challenge.core.data.ProductDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductService : ProductDataSource{
    private val retrofit = RetrofitHelper.getRetrofit()
    /*suspend fun getProducts(query: String): APIResponseSearch? {
        return withContext(Dispatchers.IO) {
            val response: Response<APIResponseSearch> =
                retrofit.create(ProductApiClient::class.java).searchItems(query)
                Log.i("***","getProducts")
                response.body()
        }
    }
    suspend fun getDetail(query:String): APIResponseProduct?{
        return withContext(Dispatchers.IO) {
            val response: Response<List<APIResponseProduct>> =
                    retrofit.create(ProductApiClient::class.java).getItem(query)
            Log.i("***","getDetail")
            response.body()?.get(0)
        }
    }*/

    override suspend fun getAllProducts(query: String): APIResponseSearch? {
        return withContext(Dispatchers.IO) {
            val response: Response<APIResponseSearch> =
                retrofit.create(ProductApiClient::class.java).searchItems(query)
            Log.i("***","getProducts")
            response.body()
        }
    }

    override suspend fun getDetailProduct(query: String): APIResponseProduct? {
        return withContext(Dispatchers.IO) {
            val response: Response<List<APIResponseProduct>> =
                retrofit.create(ProductApiClient::class.java).getItem(query)
            Log.i("***","getDetail")
            response.body()?.get(0)
        }
    }
}