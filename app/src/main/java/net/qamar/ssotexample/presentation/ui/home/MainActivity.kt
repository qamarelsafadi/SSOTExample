package net.qamar.ssotexample.presentation.ui.home

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import net.qamar.ssotexample.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = HomeViewModel(applicationContext)

        viewModel.getMovies()!!.observe(this, Observer {
            for (i in it!!.indices) {
                Log.e("qmrItems", "${it[i]!!.title}")
            }
        })
    }
}