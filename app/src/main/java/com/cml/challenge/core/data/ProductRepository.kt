package com.cml.challenge.core.data

import android.util.Log
import com.cml.challenge.app.framework.network.APIResponseProduct
import com.cml.challenge.app.framework.network.APIResponseSearch
import com.cml.challenge.app.framework.network.ProductService
import java.lang.Exception

class ProductRepository (private val dataDataSource : ProductDataSource){
    //private val api = ProductService()
    suspend fun getAllProducts(query: String): APIResponseSearch? {
        Log.i("***","getAllProducts")
        try {
               return dataDataSource.getAllProducts(query)
            }
        catch (e:Exception){
            return  null
        }
    }
    suspend fun getDetailProduct(query: String): APIResponseProduct? {
        Log.i("***","getDetail")
        try {
            return dataDataSource.getDetailProduct(query)
        }
        catch (e:Exception){
            return  null
        }
    }
}