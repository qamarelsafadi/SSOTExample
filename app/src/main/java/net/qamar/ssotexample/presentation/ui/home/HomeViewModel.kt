package net.qamar.ssotexample.presentation.ui.home

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import net.qamar.ssotexample.data.model.Movie
import net.qamar.ssotexample.data.repository.MovieRepository




class HomeViewModel(context: Context) : ViewModel() {
    private val movieRepository = MovieRepository(context)


    fun getMovies(): LiveData<List<Movie?>?>? {

        return movieRepository.getMoviesList()
    }



}