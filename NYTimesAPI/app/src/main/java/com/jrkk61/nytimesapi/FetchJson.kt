package com.jrkk61.nytimesapi

import androidx.lifecycle.MutableLiveData
import com.jrkk61.nytimesapi.NYTService.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal class FetchJson private constructor() {
    private val anInterface: Interface
    fun getArticle(section: String?, key: String?): MutableLiveData<Section?> {
        val articleData = MutableLiveData<Section?>()
        anInterface.getSection(section, key)!!.enqueue(object : Callback<Section?> {
            override fun onResponse(call: Call<Section?>, response: Response<Section?>) {
                if (response.isSuccessful) {
                    articleData.value = response.body()
                }
            }

            override fun onFailure(call: Call<Section?>, t: Throwable) {
                articleData.value = null
            }
        })
        return articleData
    }

    companion object {
        private var repository: FetchJson? = null

        val instance: FetchJson?
            get() {
                if (repository == null) {
                    repository = FetchJson()
                }
                return repository
            }
    }

    init {
        anInterface = retrofit!!.create(Interface::class.java)
    }
}