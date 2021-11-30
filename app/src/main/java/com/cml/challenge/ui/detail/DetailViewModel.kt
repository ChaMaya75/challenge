package com.cml.challenge.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cml.challenge.data.ProductRepository
import com.cml.challenge.data.network.APIResponseProduct
import com.cml.challenge.data.network.ItemSearch
import kotlinx.coroutines.launch

class DetailViewModel(private val query: String) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val detail = MutableLiveData<APIResponseProduct>()
    val indeximageshow = MutableLiveData<String>()

    suspend fun search(query: String): APIResponseProduct{

        isLoading.postValue(true)
        val repository = ProductRepository()
        val result: APIResponseProduct? = repository.getDetailProduct(query)
        if(result != null){
            Log.i("***",result.body.pictures.size.toString())

            result.body.pictures.forEach{
                Log.i("***", it.secure_url.toString())
            }
            isLoading.postValue(false)
            return result
        }else {
            Log.i("***", "Fallo al recuperar objeto")
            isLoading.postValue(false)
        }
        return result!!
    }
    init {
        Log.i("***","ProducModel Creado")
        searchDetail()
    }
    private fun searchDetail(){
        viewModelScope.launch {
            val detailProduct : APIResponseProduct = search(query)
            detail.value = detailProduct
        }
    }
}