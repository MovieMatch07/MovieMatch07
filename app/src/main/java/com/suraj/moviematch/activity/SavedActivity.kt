package com.suraj.moviematch.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.suraj.moviematch.R
import com.suraj.moviematch.adapter.HistoryMoviesAdapter
import com.suraj.moviematch.adapter.SavedMovieAdapter
import com.suraj.moviematch.adapter.SavedMovieAdapter2
import com.suraj.moviematch.app.MyApplication
import com.suraj.moviematch.dataClasses.Movie
import com.suraj.moviematch.databinding.ActivitySavedBinding
import com.suraj.moviematch.repository.MoviesRepository
import com.suraj.moviematch.viewModel.MovieViewModel
import com.suraj.moviematch.viewModel.MovieViewModelFactory
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import javax.inject.Inject

class SavedActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySavedBinding
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movieAdapter: SavedMovieAdapter2

    @Inject
    lateinit var movieRepository: MoviesRepository

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.let { ViewPumpContextWrapper.wrap(it) })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as MyApplication).movieComponent.inject(this)

        initViews()
        getSavedMovies()


    }



    private fun initViews() {

        movieViewModel =
            ViewModelProvider(this, movieViewModelFactory).get(MovieViewModel::class.java)
        binding.rvSavedList.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        movieAdapter = SavedMovieAdapter2()
        binding.rvSavedList.adapter = movieAdapter
        movieAdapter.setOnClickListener = SetOnClick()

        binding.btnSearch.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }


        binding.imgBackArrow.setOnClickListener {
            finish()
        }

    }


    private fun getSavedMovies() {

        movieViewModel.movieSavedList.observe(this) {
            if (it != null) {
                movieAdapter.addAll(it)
            }
        }

        movieViewModel.getAllMovies()

    }


    inner class SetOnClick : SavedMovieAdapter2.SetOnClickListener {
        override fun onClick(movie: Movie) {
            val intent = Intent(this@SavedActivity, MovieDetailsActivity::class.java)
            intent.putExtra("movie", movie)
            startActivity(intent)
        }

        override fun onRemoveClick(movie: Movie) {
            movieViewModel.deleteMovie(movie)
            movieViewModel.getAllMovies()
        }
    }

}