package com.suraj.moviematch.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.suraj.moviematch.R
import com.suraj.moviematch.adapter.MovieAdapter
import com.suraj.moviematch.data.Movie
import com.suraj.moviematch.data.Movies
import com.suraj.moviematch.data.getActionMovieJsonData
import com.suraj.moviematch.data.getAdventureMovieJsonData
import com.suraj.moviematch.data.getAllMovieJsonData
import com.suraj.moviematch.data.getAnimationMovieJsonData
import com.suraj.moviematch.data.getComedyMovieJsonData
import com.suraj.moviematch.data.getHorrorMovieJsonData
import com.suraj.moviematch.data.getThrillerMovieJsonData
import com.suraj.moviematch.databinding.ActivityMovieDetailsBinding
import com.suraj.moviematch.dialogs.AddReviewDialog
import com.suraj.moviematch.fragments.ReviewsFragment

class MovieDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityMovieDetailsBinding
    private var movieUrl = ""
    private var recommendation = ""
    private lateinit var movieData: Movie
    private lateinit var movieAdapter: MovieAdapter

    private var reviewsOpen = false

    private var reviewsFragment = ReviewsFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initData()

        loadDataInRecyclerView()

        setUpListener()

    }


    private fun initData() {

        val intent = getIntent()
        movieData = intent.getSerializableExtra("movie") as Movie

        movieUrl = movieData.movieUrl

        binding.txtMovieName.text = movieData.movieName.toString()

        recommendation = movieData.categories[0]

        binding.txtMovieGenres.text = buildString {
            append(movieData.categories[0])
            append(", ")
            append(movieData.categories[1])
        }


        binding.txtMovieDuration.text = movieData.length.toString()


        Glide.with(this@MovieDetailsActivity).load(movieData.imageUrl).into(binding.imgMovie)
        Glide.with(this@MovieDetailsActivity).load(movieData.imageUrl).into(binding.imgBackGround)


        val bundle = Bundle()
        bundle.putString("MovieName", movieData.movieName.toString())

        reviewsFragment.arguments = bundle
    }

    private fun setUpListener() {

        binding.btnPlayMovie.setOnClickListener {
            val intent = Intent(this@MovieDetailsActivity, PlayMoviesActivity::class.java)
            intent.putExtra("movieUrl", movieUrl)
            startActivity(intent)
            finish()
        }

        binding.imgShare.setOnClickListener {

            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, movieData.movieName)
            shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                "Watch ${movieData.movieName} with me on https://github.com/MovieMatch07/MovieMatch/releases/download/MovieMatch/MovieMatch.apk"
            )
            startActivity(Intent.createChooser(shareIntent, "Share with"))

        }

        movieAdapter.setOnClickListener = SetOnClick()


        binding.layoutReview.setOnClickListener {

            if (!reviewsOpen) {
                supportFragmentManager.beginTransaction().add(R.id.mainContainer, reviewsFragment)
                    .commit()
                reviewsOpen = true
            } else {
                supportFragmentManager.beginTransaction().remove(reviewsFragment).commit()
                reviewsOpen = false
            }
        }

    }

    override fun onBackPressed() {
        val intent = Intent(this@MovieDetailsActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun loadDataInRecyclerView() {

        var movieList : MutableList<Movie>? = ArrayList<Movie>()
        val gson = Gson()

        when {

            recommendation == "Action" -> {

                movieList = gson.fromJson(
                    getActionMovieJsonData(),
                    Movies::class.java
                ).movies as ArrayList<Movie>

            }

            recommendation == "Adventure" -> {

                movieList = gson.fromJson(
                    getAdventureMovieJsonData(),
                    Movies::class.java
                ).movies as ArrayList<Movie>

            }

            recommendation == "Animation" -> {

                movieList = gson.fromJson(
                    getAnimationMovieJsonData(),
                    Movies::class.java
                ).movies as ArrayList<Movie>

            }

            recommendation == "Comedy" -> {

                movieList = gson.fromJson(
                    getComedyMovieJsonData(),
                    Movies::class.java
                ).movies as ArrayList<Movie>

            }

            recommendation == "Horror" -> {

                movieList = gson.fromJson(
                    getHorrorMovieJsonData(),
                    Movies::class.java
                ).movies as ArrayList<Movie>

            }


            recommendation == "Thriller" -> {

                movieList = gson.fromJson(
                    getThrillerMovieJsonData(),
                    Movies::class.java
                ).movies as ArrayList<Movie>

            }

            else -> {
                movieList = gson.fromJson(
                    getAllMovieJsonData(),
                    Movies::class.java
                ).movies as ArrayList<Movie>

            }

        }


        val iterator = movieList.iterator()
        while (iterator.hasNext()) {
            val movie = iterator.next()
            if (movie == movieData) {
                iterator.remove()
            }
        }

    movieList.removeAt(movieList.size - 1)


        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        binding.rvRecommendation.layoutManager = layoutManager
        movieAdapter = MovieAdapter(movieList)
        binding.rvRecommendation.adapter = movieAdapter

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