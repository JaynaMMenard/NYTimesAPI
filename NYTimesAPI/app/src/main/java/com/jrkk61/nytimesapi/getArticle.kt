package com.jrkk61.nytimesapi

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jrkk61.nytimesapi.FetchJson.Companion.instance

class getArticle(application: Application) : AndroidViewModel(application) {
    private val mutableLiveData: MutableLiveData<Section?>
    private val repository: FetchJson?
    val articleRepository: LiveData<Section?>
        get() = mutableLiveData

    companion object {
        private const val key = "5Juyps8ID6qTGAC1bcsuk00GB6RfOzer"
    }

    init {
        repository = instance
        mutableLiveData = repository!!.getArticle("home.json", key)
    }
}