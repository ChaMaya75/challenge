package com.cml.challenge.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    val textSearch = MutableLiveData<String>()
    init {
        textSearch.value = ""
    }
    fun isEmptySearch(): Boolean {
        return textSearch.value.isNullOrEmpty()
    }
}