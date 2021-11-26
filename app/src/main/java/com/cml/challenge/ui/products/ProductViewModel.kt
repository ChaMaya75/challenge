package com.cml.challenge.ui.products

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cml.challenge.data.model.ProductModel
import com.cml.challenge.data.model.ProductProvider
import com.cml.challenge.data.network.APIResponseSearch
import com.cml.challenge.data.network.ItemSearch
import com.cml.challenge.domain.GetProductos
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    val productModel = MutableLiveData<ProductModel>()
    val isLoading = MutableLiveData<Boolean>()
    var getProduct = GetProductos()

    fun getProductModel(){
        val currentProduct:ProductModel = ProductProvider.getProduct(0)
    }
    fun onCreate(query: String) {
        viewModelScope.launch {
        isLoading.postValue(true)
            val result: APIResponseSearch? = getProduct(query)
            if(result != null){
                Log.i("***",result.results.size.toString())

                result.results.forEach{
                    Log.i("***", it.id)
                    it.id
                }
                isLoading.postValue(false)
            }else{
                Log.i("***","Fallo al recuperar la lista")
                isLoading.postValue(false)
            }
        }
    }
}