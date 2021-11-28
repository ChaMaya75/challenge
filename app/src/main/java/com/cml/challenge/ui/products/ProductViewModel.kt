package com.cml.challenge.ui.products

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cml.challenge.ChallengeApp
import com.cml.challenge.data.model.ProductModel
import com.cml.challenge.data.model.ProductProvider
import com.cml.challenge.data.network.APIResponseSearch
import com.cml.challenge.data.network.ItemSearch
import com.cml.challenge.domain.GetProductos
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(private val query: String) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    var getProduct = GetProductos()
    val productModel = MutableLiveData<List<ItemSearch>>()

    suspend fun search(query: String):List<ItemSearch> {
        isLoading.postValue(true)
            val result: APIResponseSearch? = getProduct(query)
            if(result != null){
                Log.i("***",result.results.size.toString())

                result.results.forEach{
                    Log.i("***", it.id)
                    it.id
                }
                isLoading.postValue(false)
                return result.results
            }else {
                Log.i("***", "Fallo al recuperar la lista")
                isLoading.postValue(false)
            }
        return emptyList()
    }
    init {
        Log.i("***","ProducModel Creado")
        searchProduct()
    }

    override fun onCleared() {
        Log.i("***","ProducModel Borrado!!!")
        super.onCleared()
    }
    private fun searchProduct(){
        viewModelScope.launch {
            val productos : List<ItemSearch> = search(query)
            productModel.value = productos
        }

    }
}