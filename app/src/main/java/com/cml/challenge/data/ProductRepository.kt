package com.cml.challenge.data

import android.util.Log
import com.cml.challenge.data.network.APIResponseSearch
import com.cml.challenge.data.network.ProductService
import java.lang.Exception

class ProductRepository {
    private val api = ProductService()
    suspend fun getAllProducts(query: String): APIResponseSearch? {
        Log.i("***","getAllProducts")
        try {
               return api.getProducts(query)
            }
        catch (e:Exception){
            return  null
        }
    }
}