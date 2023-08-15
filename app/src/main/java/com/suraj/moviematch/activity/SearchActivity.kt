package com.suraj.moviematch.activity

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.gson.Gson
import com.suraj.moviematch.adapter.MovieAdapter
import com.suraj.moviematch.app.MyApplication
import com.suraj.moviematch.dataClasses.Movie
import com.suraj.moviematch.dataClasses.Movies
import com.suraj.moviematch.data.getAllMovieJsonData
import com.suraj.moviematch.databinding.ActivitySearchBinding
import com.suraj.moviematch.repository.MoviesRepository
import com.suraj.moviematch.viewModel.MovieViewModel
import com.suraj.moviematch.viewModel.MovieViewModelFactory
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import javax.inject.Inject

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var layoutManager: StaggeredGridLayoutManager
    private lateinit var movieViewModel: MovieViewModel
    private val movieList = ArrayList<Movie>()

    @Inject
    lateinit var movieRepository: MoviesRepository

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.let { ViewPumpContextWrapper.wrap(it) })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as MyApplication).movieComponent.inject(this)

        binding.edtSearch.requestFocus()

        initViews()

        setOnClick()

        setUpViewModel()

    }

    private fun initViews() {
        movieViewModel = ViewModelProvider(this, movieViewModelFactory).get(MovieViewModel::class.java)

        layoutManager = StaggeredGridLayoutManager(
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 4 else 2,
            StaggeredGridLayoutManager.VERTICAL
        )

        val gson = Gson()
        val movies = gson.fromJson(getAllMovieJsonData(), Movies::class.java)
        movieList.addAll(movies.movies)

        binding.rvSearchMovie.layoutManager = layoutManager

        movieAdapter = MovieAdapter(1)
        binding.rvSearchMovie.adapter = movieAdapter
        movieAdapter.setOnClickListener = SetOnClick()
    }

    private fun setUpViewModel() {
        movieViewModel.movieList.observe(this) {
            movieList.addAll(it)
            movieAdapter.addAll(movieList)
        }
        movieViewModel.loadMoviesByFilter("All")
    }

    private fun filterMovies(query: String) {
        val uniqueMovieNames = HashSet<String>() // To store unique movie names
        val filteredList = mutableListOf<Movie>()

        for (movie in movieList) {
            val lowercaseMovieName = movie?.movieName?.trim()?.lowercase()
            if (lowercaseMovieName != null && lowercaseMovieName.contains(query.trim().lowercase())) {
                // Check if the movie name is unique, then add it to the filtered list
                if (uniqueMovieNames.add(lowercaseMovieName)) {
                    filteredList.add(movie)
                }
            }
        }

        movieAdapter.clearList() // Clear the previous list
        movieAdapter.addAll(filteredList) // Add the filtered list
    }


    private fun setOnClick() {
        binding.edtSearch.addTextChangedListener {
            filterMovies(it.toString().trim())
        }

        binding.imgBackArrow.setOnClickListener {
            val intent = Intent(this@SearchActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.imgClose.setOnClickListener {
            binding.edtSearch.setText("")
            filterMovies("")
        }
    }

    inner class SetOnClick : MovieAdapter.SetOnClickListener {
        override fun onClick(movie: Movie) {
            val intent = Intent(this@SearchActivity, MovieDetailsActivity::class.java)
            intent.putExtra("movie", movie)
            startActivity(intent)
            finish()
        }
    }
}
