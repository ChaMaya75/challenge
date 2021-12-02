package com.cml.challenge.core.data

import android.util.Log
import com.cml.challenge.app.framework.network.APIResponseProduct
import com.cml.challenge.app.framework.network.APIResponseSearch
import com.cml.challenge.app.framework.network.ProductService
import com.cml.challenge.core.model.DetailModel
import com.cml.challenge.core.model.ProductModel
import java.lang.Exception

class ProductRepository (private val dataDataSource : ProductDataSource){

    suspend fun getAllProducts(query: String): List<ProductModel>? {
        Log.i("***","getAllProducts")
        try {
               return dataDataSource.getAllProducts(query)
            }
        catch (e:Exception){
            return  null
        }
    }
    suspend fun getDetailProduct(query: String): DetailModel? {
        Log.i("***","getDetail")
        try {
            return dataDataSource.getDetailProduct(query)
        }
        catch (e:Exception){
            return  null
        }
    }
}