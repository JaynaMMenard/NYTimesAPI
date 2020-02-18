package com.jrkk61.nytimesapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object NYTService {

    var retrofit: Retrofit? = null
        get() {
            if (field == null) {
                field = Retrofit.Builder().baseUrl("https://api.nytimes.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return field
        }

}