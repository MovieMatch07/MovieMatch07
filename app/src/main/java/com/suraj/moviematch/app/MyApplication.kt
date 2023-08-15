package com.suraj.moviematch.app

import android.app.Application
import com.suraj.moviematch.di.DaggerMovieComponent
import com.suraj.moviematch.di.MovieComponent
import com.suraj.moviematch.di.NetworkModule
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.calligraphy3.R
import io.github.inflationx.viewpump.ViewPump

class MyApplication : Application() {

    lateinit var movieComponent: MovieComponent

    override fun onCreate() {
        super.onCreate()

        movieComponent =
            DaggerMovieComponent.builder().networkModule(NetworkModule(applicationContext)).build()

        initFont()

    }

    fun initFont() {
        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("fonts/FrankRuhlLibre-Bold.ttf")
                            .setFontAttrId(R.attr.fontPath)
                            .build()
                    )
                )
                .build()
        )
    }


}