
package com.jrkk61.nytimesapi
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jrkk61.nytimesapi.R
import com.jrkk61.nytimesapi.Adapter
import com.jrkk61.nytimesapi.ArticleM
import java.util.*

class ArticleActivity : AppCompatActivity() {
    private var adapter: Adapter? = null
    private val articles = ArrayList<ArticleM>()
    private var section: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)

        section = intent.getStringExtra("section")
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        adapter = Adapter(this, articles)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)


    }
}