package com.jrkk61.nytimesapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NYTService {

    var retrofit: Retrofit? = null
        get() {
                field = Retrofit.Builder().baseUrl("https://api.nytimes.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

            return field
        }

}