package com.cml.challenge.app.framework.network

import com.cml.challenge.core.model.ProductModel

data class APIResponseProducts(
    val status: Int,
    val error: String,
    val results: List<ProductModel>
)

