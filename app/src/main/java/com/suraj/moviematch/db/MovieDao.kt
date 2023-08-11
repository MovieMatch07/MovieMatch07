package com.suraj.moviematch.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.suraj.moviematch.dataClasses.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    suspend fun getAllMovies(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie)

    @Delete
    suspend fun deleteMovie(movie: Movie)
}
