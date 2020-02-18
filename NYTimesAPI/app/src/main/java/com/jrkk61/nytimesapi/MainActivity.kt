<<<<<<< HEAD

package com.jrkk61.nytimesapi

import android.content.*
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.jrkk61.nytimesapi.R
import com.jrkk61.nytimesapi.Adapter
import com.jrkk61.nytimesapi.ArticleM
import com.jrkk61.nytimesapi.Section
import com.jrkk61.nytimesapi.getArticle
import java.util.*

    class MainActivity : AppCompatActivity() {
    private var adapter: Adapter? = null
    private val articles = ArrayList<ArticleM>()
    private var loading: ProgressBar? = null
    private var snackbar: Snackbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = "Home"
        loading= findViewById(R.id.load)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        adapter = Adapter(this, articles)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        val v = findViewById<View>(R.id.constraint)
        snackbar = Snackbar.make(v, "NO Internet Connection", Snackbar.LENGTH_INDEFINITE)
                .setAction("Retry") { v1: View? -> load() }

    }

    private val networkChangeReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            load()
        }
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(networkChangeReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(networkChangeReceiver)
    }


    private fun load() {
        if (connectionAvailable()) {

            if (adapter!!.itemCount == 0) {
                loading!!.visibility = View.VISIBLE
                val model = ViewModelProviders.of(this).get(getArticle::class.java)
                model.articleRepository.observe(this, Observer { section1: Section? ->
                    if (section1 == null) {
                        loading!!.visibility = View.GONE
                    } else {
                        val articleList = section1.results
                        articles.addAll(articleList)
                        adapter!!.notifyDataSetChanged()
                        loading!!.visibility = View.GONE
                    }
                }
                )
            }
        } else {
            loading!!.visibility = View.INVISIBLE
            if (adapter!!.itemCount == 0) {
                val v = findViewById<View>(R.id.constraint)
                snackbar = Snackbar.make(v, "NO Internet Connection", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Retry") { v1: View? -> load() }
                snackbar!!.setActionTextColor(Color.WHITE)
                snackbar!!.show()
            }
        }
    }

    private fun connectionAvailable(): Boolean {
        var connected = false
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Objects.requireNonNull(connectivityManager).getNetworkInfo(ConnectivityManager.TYPE_MOBILE).state == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).state == NetworkInfo.State.CONNECTED) {
            connected = true
        }
        return connected
    }

}
=======
package com.jrkk61.nytimesapi
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jrkk61.nytimesapi.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
>>>>>>> e301c2208c3ed350042d9d4a6b36d339dcd01603
