package com.suraj.moviematch.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.suraj.moviematch.R
import com.suraj.moviematch.data.Movie
import com.suraj.moviematch.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {

     lateinit var binding: ActivityMovieDetailsBinding
    private var movieUrl = ""
   private lateinit var movieData : Movie


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initData()

        setUpListener()

    }

    private fun initData() {
        val intent = getIntent()
        movieData =  intent.getSerializableExtra("movie") as Movie

        movieUrl = movieData.movieUrl
    }

    private fun setUpListener() {

        binding.btnPlayMovie .setOnClickListener {
            val intent = Intent(this@MovieDetailsActivity, PlayMoviesActivity::class.java)
            intent.putExtra("movieUrl", movieUrl)
            startActivity(intent)
            finish()
        }

        binding.imgShare.setOnClickListener {

            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, movieData.movieName)
            shareIntent.putExtra(Intent.EXTRA_TEXT,"Watch ${movieData.movieName} with me on https://github.com/MovieMatch07/MovieMatch/releases/download/MovieMatch/MovieMatch.apk"  )
            startActivity(Intent.createChooser(shareIntent, "Share with"))

        }

    }
}