package com.cml.challenge.domain

import com.cml.challenge.data.ProductRepository
import com.cml.challenge.data.network.APIResponseProduct
import com.cml.challenge.data.network.APIResponseSearch

class GetProductos (){
    private val repository = ProductRepository()
    suspend operator fun invoke(query: String): APIResponseSearch? = repository.getAllProducts(query)
}