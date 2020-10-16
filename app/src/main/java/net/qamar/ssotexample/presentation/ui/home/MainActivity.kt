package net.qamar.ssotexample.presentation.ui.home

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import dagger.android.support.DaggerAppCompatActivity
import net.qamar.ssotexample.R
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = HomeViewModel(this)
        viewModel.getMovies().observe(this, Observer {
            for (i in it.indices)
                Log.e("qmrItemsTitle", "${it[i].title}")

        })


    }
}