package com.suraj.moviematch.viewModel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.suraj.moviematch.dataClasses.Movie
import com.suraj.moviematch.dataClasses.MovieReview
import com.suraj.moviematch.dataClasses.Shorts
import com.suraj.moviematch.db.DatabaseProvider
import com.suraj.moviematch.db.MovieDao
import com.suraj.moviematch.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(private var movieRepository: MoviesRepository) : ViewModel() {


    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = _movieList


    private val _movieReviewList = MutableLiveData<List<MovieReview>?>()
    val movieReviewList: LiveData<List<MovieReview>?>
        get() = _movieReviewList


    private val _movieSavedList = MutableLiveData<List<Movie>?>()
    val movieSavedList: LiveData<List<Movie>?>
        get() = _movieSavedList



    private val _shortsLiveData = MutableLiveData<List<Shorts>>()
    val shortsLiveData: LiveData<List<Shorts>> = _shortsLiveData

    fun loadMoviesByFilter(filter: String) {
        val movies = movieRepository.getMoviesByFilter(filter)
        _movieList.postValue(movies)
    }


    fun addReview(movieName: String, review: MovieReview) {
        viewModelScope.launch(Dispatchers.IO) {
            movieRepository.addReview(movieName, review)
        }
    }


    fun getReviews(movieName: String) {
        viewModelScope.launch {
            var review = movieRepository.getReviews(movieName)
            _movieReviewList.postValue(review)
        }
    }


    fun getAllMovies() {
        viewModelScope.launch {
            var savedMovies = movieRepository.getAllMovies()
            _movieSavedList.postValue(savedMovies)
            Log.e("GetSavedMoviesData","$_movieSavedList")
        }
    }

    fun insertMovie(movie: Movie) {
        viewModelScope.launch {
            movieRepository.insertMovie(movie)
        }
    }


    fun deleteMovie(movie: Movie) {
        viewModelScope.launch {
            movieRepository.deleteMovie(movie)
        }
    }


    fun addShort(short: Shorts) {
        movieRepository.addShort(short)
    }

    fun getShorts() {
        movieRepository.getShorts { shortsList ->
            _shortsLiveData.postValue(shortsList)
        }
    }

}


