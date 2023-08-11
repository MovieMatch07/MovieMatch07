package com.suraj.moviematch.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.suraj.moviematch.R
import com.suraj.moviematch.adapter.MovieAdapter
import com.suraj.moviematch.app.MyApplication
import com.suraj.moviematch.dataClasses.Movie
import com.suraj.moviematch.databinding.ActivityMovieDetailsBinding
import com.suraj.moviematch.fragments.ReviewsFragment
import com.suraj.moviematch.repository.MoviesRepository
import com.suraj.moviematch.viewModel.MovieViewModel
import com.suraj.moviematch.viewModel.MovieViewModelFactory
import javax.inject.Inject

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding
    private lateinit var movieData: Movie
    private lateinit var movieAdapter: MovieAdapter
    private var reviewsOpen = false
    private lateinit var movieViewModel: MovieViewModel
    private var moviesList = ArrayList<Movie>()
    private var movieSavedList = ArrayList<Movie>()
    private val reviewsFragment = ReviewsFragment()

    @Inject
    lateinit var movieRepository: MoviesRepository

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory

    var isSaved = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as MyApplication).movieComponent.inject(this)

        initData()
        getSavedMovies()
        loadDataInRecyclerView()
        setUpViewModel()
        setUpListeners()


        if (isSaved)
            binding.imgSave.setImageResource(R.drawable.ic_save)
        else
            binding.imgSave.setImageResource(R.drawable.ic_unsave)

    }

    private fun initData() {
        val intent = intent
        movieData = intent.getSerializableExtra("movie") as Movie

        // Set UI elements with movie data


        movieViewModel =
            ViewModelProvider(this, movieViewModelFactory).get(MovieViewModel::class.java)

        binding.txtMovieName.text = movieData.movieName.toString()
        binding.txtMovieGenres.text = movieData.categories.joinToString(", ")
        binding.txtMovieDuration.text = movieData.length.toString()

        Glide.with(this@MovieDetailsActivity)
            .load(movieData.imageUrl)
            .into(binding.imgMovie)

        val bundle = Bundle()
        bundle.putString("MovieName", movieData.movieName.toString())
        reviewsFragment.arguments = bundle


    }


    private fun loadDataInRecyclerView() {

        movieViewModel.loadMoviesByFilter(movieData.categories[0])

        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        binding.rvRecommendation.layoutManager = layoutManager

        movieAdapter = MovieAdapter(0)

        binding.rvRecommendation.adapter = movieAdapter

        movieAdapter.setOnClickListener = SetOnClick()


    }


    private fun setUpViewModel() {
        movieViewModel.movieList.observe(this) {

            if (it.isNotEmpty()) {
                moviesList.clear()
                moviesList.addAll(it)
                movieAdapter.addAll(moviesList)
            }
        }
    }


    private fun setUpListeners() {
        binding.btnPlayMovie.setOnClickListener {
            val intent = Intent(this@MovieDetailsActivity, PlayMoviesActivity::class.java)
            intent.putExtra("movieUrl", movieData.movieUrl)
            startActivity(intent)
            finish()
        }

        // Other listeners setup

        binding.imgSave.setOnClickListener {

            if (isSaved) {
                movieViewModel.deleteMovie(movieData)
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show()
                binding.imgSave.setImageResource(R.drawable.ic_unsave)

            } else {
                movieViewModel.insertMovie(movieData)
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                binding.imgSave.setImageResource(R.drawable.ic_save)
            }


        }

        binding.layoutReview.setOnClickListener {
            if (!reviewsOpen) {
                supportFragmentManager.beginTransaction()
                    .add(R.id.mainContainer, reviewsFragment)
                    .commit()
                reviewsOpen = true
            } else {
                supportFragmentManager.beginTransaction()
                    .remove(reviewsFragment)
                    .commit()
                reviewsOpen = false
            }
        }


        binding.imgShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(
                Intent.EXTRA_SUBJECT,
                getString(R.string.app_name)
            )
            shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                "Download the app from: https://github.com/MovieMatch07/MovieMatch07/releases/download/android/MovieMatch.apk"
            )
            startActivity(Intent.createChooser(shareIntent, "Share App using"))
        }

    }


    fun getSavedMovies() {
        movieViewModel.getAllMovies()
        movieViewModel.movieSavedList.observe(this) {
            if (it != null) {
                movieSavedList.addAll(it)
                Log.e("getSavedMovies", "${it}")
                for (m in it){
                    if (m == movieData) isSaved = true
                }

            }
        }
        movieViewModel.getAllMovies()
    }



    override fun onBackPressed() {
        val intent = Intent(this@MovieDetailsActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    inner class SetOnClick : MovieAdapter.SetOnClickListener {
        override fun onClick(movie: Movie) {
            val intent = Intent(this@MovieDetailsActivity, MovieDetailsActivity::class.java)
            intent.putExtra("movie", movie)
            startActivity(intent)
            finish()
        }
    }
}
