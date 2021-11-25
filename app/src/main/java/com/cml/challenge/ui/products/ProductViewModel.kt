package com.cml.challenge.ui.products

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cml.challenge.data.model.ProductModel
import com.cml.challenge.data.model.ProductProvider

class ProductViewModel : ViewModel() {
    val productModel = MutableLiveData<ProductModel>()
    fun getProductModel(){
        val currentProduct:ProductModel = ProductProvider.getProduct(0)
    }
}