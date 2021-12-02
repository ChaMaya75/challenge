package com.cml.challenge.core.data

import com.cml.challenge.core.model.DetailModel
import com.cml.challenge.core.model.ProductModel

interface ProductDataSource {
    suspend fun getAllProducts(query: String): List<ProductModel>?
    suspend fun getDetailProduct(query: String): DetailModel?
}