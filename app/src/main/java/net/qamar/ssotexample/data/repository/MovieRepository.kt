package net.qamar.ssotexample.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import net.qamar.ssotexample.data.local.dao.MovieDao
import net.qamar.ssotexample.data.local.database.AppDatabase
import net.qamar.ssotexample.data.model.Movie
import net.qamar.ssotexample.data.remote.api.MovieApi
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers


class MovieRepository(private val  context: Context) : BaseRepository() {
    private val movieApi = getRetrofitHelper()!!.getService(MovieApi::class.java)

    private val appDatabase = AppDatabase.getInstance(context)
     var movieDao = appDatabase!!.movieDao!!

    fun getMoviesList(): LiveData<List<Movie?>?>? {
        val result = movieApi.movieList()
        result!!.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (!it!!.isSuccessful) {

                    Log.e("qmr", "not respond");

                } else {
                    movieDao.insert(it.body()!!.search);
                }

            }, { throwable ->
                Log.i("qmrThrowable", throwable.message.toString())
            })

        return movieDao.all
    }


}