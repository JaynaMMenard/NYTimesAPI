package com.jrkk61.nytimesapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.util.*

class Adapter(private val context: Context, private val articles: ArrayList<ArticleM>) : RecyclerView.Adapter<Adapter.holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        val inflater = LayoutInflater.from(context)
        return holder(inflater.inflate(R.layout.article_card, parent, false))
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        holder.title.text = articles[position].title
        holder.blur.text = articles[position].abstract
        if (articles[position].multimedia.size == 0) {

        } else {
            Picasso.get().load(articles[position].multimedia[1].url).into(holder.multimedia)
        }
    }

    override fun getItemCount(): Int {
        return articles.count()
    }

     class holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val multimedia: ImageView
        val title: TextView
        val blur: TextView


        init {
           multimedia= itemView.findViewById(R.id.multimedia)
            title = itemView.findViewById(R.id.title)
            blur = itemView.findViewById(R.id.blur)

        }
    }

}