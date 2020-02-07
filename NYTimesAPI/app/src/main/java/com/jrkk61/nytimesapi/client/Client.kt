package com.jrkk61.nytimesapi.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {

    private var retrofit: Retrofit? = null

    //API base Url
    /*The specified endpoint values (such as with @GET) are resolved against this value
      using HttpUrl.resolve(String). The behavior of this matches that of an <a href="">
      link on a website resolving on the current URL.*/


    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                    //Gson to Json
                .addConverterFactory(GsonConverterFactory.create())
                .build()


        }
        //converts any value to a non-null type and throws an exception if the value is null.
    return retrofit!!

    }
}