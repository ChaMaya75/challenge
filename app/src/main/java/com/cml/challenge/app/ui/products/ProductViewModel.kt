package com.cml.challenge.app.ui.products

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cml.challenge.core.data.ProductRepository
import com.cml.challenge.app.framework.network.ProductService
import com.cml.challenge.core.model.ProductModel
import com.cml.challenge.core.usecase.GetAllProducts
import com.cml.challenge.test.ProductTest
import kotlinx.coroutines.launch

class ProductViewModel(private val query: String) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val productModel = MutableLiveData<List<ProductModel>>()
    val isEmpty = MutableLiveData<Boolean>()

    suspend fun search(query: String):List<ProductModel> {
        isLoading.postValue(true)

            //val repository = ProductRepository(ProductTest(0))          //Para pruebas y desarollo
                                                                        //0 regresa null
                                                                        //1 regresa lista vacia
                                                                        // otro numero regresa 3 productos

            val repository = ProductRepository(ProductService())    //Productivo
            val result: List<ProductModel>? = GetAllProducts(repository).invoke(query)
            if(result != null){
                Log.i("***",result.size.toString())

                result.forEach{
                    Log.i("***", it.id)
                    it.id
                }
                isEmpty.postValue(result.isEmpty())
                isLoading.postValue(false)
                return result
            }else {
                isEmpty.postValue(true)
                Log.i("***", "Fallo al recuperar la lista")
                isLoading.postValue(false)
            }
        isEmpty.postValue(true)
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
            val productos : List<ProductModel> = search(query)
            productModel.value = productos
        }

    }
}