package com.cml.challenge.core.usecase

import com.cml.challenge.core.data.ProductRepository
import com.cml.challenge.core.model.ProductModel

class GetAllProducts(private val productRepository:ProductRepository) {
    suspend operator fun invoke(query:String):List<ProductModel>? = productRepository.getAllProducts(query)
}