package com.cml.challenge.app.framework.network

import android.util.Log
import com.cml.challenge.core.data.ProductDataSource
import com.cml.challenge.core.model.DetailModel
import com.cml.challenge.core.model.ProductModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductService : ProductDataSource{
    private val retrofit = RetrofitHelper.getRetrofit()
    override suspend fun getAllProducts(query: String): List<ProductModel>? {
        return withContext(Dispatchers.IO) {
            val response: Response<APIResponseProducts> =
                retrofit.create(ProductApiClient::class.java).searchItems(query)
            Log.i("***","getProducts")
            response.body()?.results
        }
    }

    override suspend fun getDetailProduct(query: String): DetailModel? {
        return withContext(Dispatchers.IO) {
            val responseDetail: Response<List<APIResponseDetailProduct>> =
                retrofit.create(ProductApiClient::class.java).getItem(query)
            Log.i("***","getDetail")
            responseDetail.body()?.get(0)?.body
        }
    }
}