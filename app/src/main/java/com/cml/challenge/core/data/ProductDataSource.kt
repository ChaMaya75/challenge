package com.cml.challenge.core.data

import com.cml.challenge.app.framework.network.APIResponseProduct
import com.cml.challenge.app.framework.network.APIResponseSearch

interface ProductDataSource {
    suspend fun getAllProducts(query: String): APIResponseSearch?
    suspend fun getDetailProduct(query: String): APIResponseProduct?
}