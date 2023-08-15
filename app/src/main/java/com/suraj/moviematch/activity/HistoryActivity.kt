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
import com.suraj.moviematch.adapter.HistoryMoviesAdapter2
import com.suraj.moviematch.adapter.SavedMovieAdapter
import com.suraj.moviematch.app.MyApplication
import com.suraj.moviematch.dataClasses.Movie
import com.suraj.moviematch.databinding.ActivityHistoryBinding
import com.suraj.moviematch.repository.MoviesRepository
import com.suraj.moviematch.viewModel.MovieViewModel
import com.suraj.moviematch.viewModel.MovieViewModelFactory
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import javax.inject.Inject

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var historyMoviesAdapter: HistoryMoviesAdapter2
    private var moviesList = ArrayList<Movie>()

    @Inject
    lateinit var movieRepository: MoviesRepository

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.let { ViewPumpContextWrapper.wrap(it) })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as MyApplication).movieComponent.inject(this)

        initViews()

        initData()


    }


    private fun initViews() {

        movieViewModel =
            ViewModelProvider(this, movieViewModelFactory).get(MovieViewModel::class.java)

        binding.rvHistoryList.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        historyMoviesAdapter = HistoryMoviesAdapter2()
        binding.rvHistoryList.adapter = historyMoviesAdapter
        historyMoviesAdapter.setOnClickListener = SetOnClick()

        binding.imgBackArrow.setOnClickListener {
            finish()
        }

    }

    private fun initData() {


        movieViewModel.historyList.observe(this) {
            if (it != null) {
                moviesList.clear()
                moviesList.addAll(it)
                historyMoviesAdapter.addAll(moviesList)
            }
        }

    }


    inner class SetOnClick : HistoryMoviesAdapter2.SetOnClickListener {
        override fun onClick(movie: Movie) {
            val intent = Intent(this@HistoryActivity, MovieDetailsActivity::class.java)
            intent.putExtra("movie", movie)
            startActivity(intent)
        }

        override fun onRemoveClick(movie: Movie) {
            movieViewModel.deleteMovieFromHistory(movie)

            moviesList.remove(movie)

            historyMoviesAdapter.addAll(moviesList)


        }
    }


}