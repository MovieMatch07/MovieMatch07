package com.suraj.moviematch.dataClasses

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movie")
data class Movie(

    val movieUrl: String = "",
    val imageUrl: String = "",
    @PrimaryKey
    val movieName: String = "",
    val categories: List<String> = emptyList(),
    val length: String = ""
) : Serializable
