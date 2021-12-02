package com.cml.challenge.app.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cml.challenge.core.data.ProductRepository
import com.cml.challenge.app.framework.network.ProductService
import com.cml.challenge.core.model.DetailModel
import com.cml.challenge.core.usecase.GetDetailProduct
import com.cml.challenge.test.ProductTest
import kotlinx.coroutines.launch

class DetailViewModel(private val query: String) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val detail = MutableLiveData<DetailModel>()
    val indeximageshow = MutableLiveData<String>()
    val isDetailValid = MutableLiveData<Boolean>()

    suspend fun search(query: String): DetailModel? {

        isLoading.postValue(true)

        //val repository = ProductRepository(ProductTest(0))  //Para pruebas y desarrollo
                                                            //0 regresa null
                                                            //otro valor regresa un detalle valido

        val repository = ProductRepository(ProductService())   //Productivo

        var result: DetailModel? = GetDetailProduct(repository).invoke(query)
        if(result != null){

            Log.i("***",result.pictures.size.toString())
            result.pictures.forEach{
                Log.i("***", it.secure_url.toString())
            }
            isDetailValid.postValue(true)
            isLoading.postValue(false)
            return result
        }else {
            Log.i("***", "Fallo al recuperar objeto")
            isLoading.postValue(false)
        }
        isDetailValid.postValue(false)
        return result
    }
    init {
        Log.i("***","ProducModel Creado")
        searchDetail()
    }
    private fun searchDetail(){
        viewModelScope.launch {
            val detailProduct : DetailModel? = search(query)
            if(detailProduct != null)
                detail.value = detailProduct
        }
    }
}