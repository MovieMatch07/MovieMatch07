package com.suraj.moviematch.app

import android.app.Application
import com.suraj.moviematch.di.DaggerMovieComponent
import com.suraj.moviematch.di.MovieComponent
import com.suraj.moviematch.di.NetworkModule

class MyApplication : Application() {

    lateinit var movieComponent: MovieComponent

    override fun onCreate() {
        super.onCreate()

        movieComponent =
            DaggerMovieComponent.builder().networkModule(NetworkModule(applicationContext)).build()

    }


}