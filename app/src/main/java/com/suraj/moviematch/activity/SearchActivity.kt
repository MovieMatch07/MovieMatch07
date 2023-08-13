package com.suraj.moviematch.activity

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.gson.Gson
import com.suraj.moviematch.adapter.MovieAdapter
import com.suraj.moviematch.dataClasses.Movie
import com.suraj.moviematch.dataClasses.Movies
import com.suraj.moviematch.data.getAllMovieJsonData
import com.suraj.moviematch.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    var movieList = ArrayList<Movie>()
    private lateinit var movieAdapter: MovieAdapter
    lateinit var layoutManager: StaggeredGridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.edtSearch.requestFocus()


        initData()

        setOnClick()


    }

    private fun initData() {

        val orientation = resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            layoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
        } else {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }

        val gson = Gson()


        movieList = gson.fromJson(
            getAllMovieJsonData(),
            Movies::class.java
        ).movies as ArrayList<Movie>




        binding.rvSearchMovie.layoutManager = layoutManager

    }


    private fun filterMovies(query: String) {
        var filteredList = ArrayList<Movie>()

        if (query.isEmpty() || query.isBlank()){

        }
        else {

            for (movie in movieList) {
                if (movie != null && movie.movieName.trim().lowercase()
                        .contains(query.trim().lowercase()) && query.isNotEmpty()
                ) {
                    filteredList.add(movie)
                    Log.e("MovieData", movie.movieName)
                }
            }
        }
        movieAdapter = MovieAdapter( 1)

        binding.rvSearchMovie.adapter = movieAdapter

        movieAdapter.setOnClickListener = SetOnClick()
    }


    private fun setOnClick() {


        binding.edtSearch.addTextChangedListener {

            if (binding.edtSearch.text.toString().trim().isNotEmpty()) filterMovies(binding.edtSearch.text.toString().trim())

        }


        binding.imgBackArrow.setOnClickListener {
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
