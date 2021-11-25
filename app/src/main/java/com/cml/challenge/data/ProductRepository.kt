package com.cml.challenge.data

import com.cml.challenge.data.model.ProductModel
import com.cml.challenge.data.network.APIResponseSearch
import com.cml.challenge.data.network.ProductService

class ProductRepository {
    private val api = ProductService()
    /*suspend fun getAllProducts(): APIResponseSearch{
        val response:ProductModel = api.getProducts()
    }*/
}