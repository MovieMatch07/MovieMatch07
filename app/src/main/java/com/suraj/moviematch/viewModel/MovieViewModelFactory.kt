package com.suraj.moviematch.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.suraj.moviematch.repository.MoviesRepository

class MovieViewModelFactory(private val movieRepository: MoviesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            return MovieViewModel(movieRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
