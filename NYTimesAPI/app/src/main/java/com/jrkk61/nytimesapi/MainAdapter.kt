package com.jrkk61.nytimesapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.article.view.*
import okhttp3.*
import java.io.IOException

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>() {
    val articleTitle = listOf<String>("hana", "dul", "set")

    override fun getItemCount(): Int {
        return articleTitle.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cell = layoutInflater.inflate(R.layout.article, parent, false)
        return CustomViewHolder (cell)
    }



    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val articleTitle = articleTitle.get(position)
        holder.view.textView.text = articleTitle

        fetchJson()
    }
//    fun fetchJson(){
//        println("Fetching Json")
//        val url = "https://api.nytimes.com/svc/topstories/v2/us.json?api-key=5Juyps8ID6qTGAC1bcsuk00GB6RfOzer"
//        val request = Request.Builder().url(url).build()
//
//        val client = OkHttpClient()
//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                 //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                //To change body of created functions use File | Settings | File Templates.
//            }
//
//        })
//
//    }


}


