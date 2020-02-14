package com.jrkk61.nytimesapi

import okhttp3.*
import java.io.IOException

fun fetchJson(){
        println("Fetching Json")
        val url = "https://api.nytimes.com/svc/topstories/v2/us.json?api-key=5Juyps8ID6qTGAC1bcsuk00GB6RfOzer"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {
              val body = response.body()?.string() //To change body of created functions use File | Settings | File Templates.
                println(body)
            }
            override fun onFailure(call: Call, e: IOException) {
               println("Failed") //To change body of created functions use File | Settings | File Templates.
            }


            
        })

    }