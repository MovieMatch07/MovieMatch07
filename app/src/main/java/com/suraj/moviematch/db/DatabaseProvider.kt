package com.suraj.moviematch.db

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    private var instance: MovieDatabase? = null

    fun getDatabase(context: Context): MovieDatabase {
        if (instance == null) {
            instance = Room.databaseBuilder(
                context.applicationContext,
                MovieDatabase::class.java,
                "movie_database"
            ).build()
        }
        return instance!!
    }
}
