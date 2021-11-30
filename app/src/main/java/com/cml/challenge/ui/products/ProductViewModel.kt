package com.cml.challenge.ui.products

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cml.challenge.data.ProductRepository
import com.cml.challenge.data.network.APIResponseSearch
import com.cml.challenge.data.network.ItemSearch
import kotlinx.coroutines.launch

class ProductViewModel(private val query: String) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val productModel = MutableLiveData<List<ItemSearch>>()

    suspend fun search(query: String):List<ItemSearch> {
        isLoading.postValue(true)
            val repository = ProductRepository()
            val result: APIResponseSearch? = repository.getAllProducts(query)
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