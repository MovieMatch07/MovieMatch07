package com.suraj.moviematch.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.suraj.moviematch.dataClasses.Movie

@Database(entities = [Movie::class], version = 1)
@TypeConverters(CategoryListConverter::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
