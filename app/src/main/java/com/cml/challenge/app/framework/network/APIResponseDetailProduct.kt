package com.cml.challenge.app.framework.network

import com.cml.challenge.core.model.DetailModel

data class APIResponseDetailProduct(
    val body: DetailModel,
    val code: Int
)