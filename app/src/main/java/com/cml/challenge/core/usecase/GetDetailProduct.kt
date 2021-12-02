package com.cml.challenge.core.usecase

import com.cml.challenge.core.data.ProductRepository
import com.cml.challenge.core.model.DetailModel

class GetDetailProduct(private val productRepository: ProductRepository) {
    suspend operator fun invoke(query:String):DetailModel? = productRepository.getDetailProduct(query)
}