package net.qamar.ssotexample.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import net.qamar.ssotexample.data.local.database.AppDatabase
import net.qamar.ssotexample.data.model.Movie
import net.qamar.ssotexample.data.remote.api.MovieApi
import net.qamar.ssotexample.data.util.di.DaggerAppComponent
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject


class MovieRepository(context: Context) {

    @Inject
     lateinit var  movieApi :MovieApi

    private val appDatabase = AppDatabase.getInstance(context)
     private var movieDao = appDatabase!!.movieDao!!

    init {
        DaggerAppComponent.create().inject(this)

    }
    fun getMoviesList(): LiveData<List<Movie>> {
        val result = movieApi.movieList()
        result.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (!it!!.isSuccessful) {

                    Log.e("qmr", "not respond")

                } else {

                    movieDao.insert(it.body()!!.search)
                }

            }, { throwable ->
                Log.i("qmrThrowable", throwable.message.toString())
            })

        return movieDao.all
    }


}