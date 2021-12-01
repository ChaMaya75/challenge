package com.cml.challenge.data.network

import com.cml.challenge.data.model.ProductModel

data class APIResponseSearch(
    val status: Int,
    val error: String,
    val results: List<ProductModel>
)

