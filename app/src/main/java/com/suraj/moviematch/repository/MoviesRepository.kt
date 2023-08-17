package com.suraj.moviematch.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.suraj.moviematch.dataClasses.Movie
import com.suraj.moviematch.dataClasses.Movies
import com.suraj.moviematch.data.getActionMovieJsonData
import com.suraj.moviematch.data.getAdventureMovieJsonData
import com.suraj.moviematch.data.getAllMovieJsonData
import com.suraj.moviematch.data.getAnimationMovieJsonData
import com.suraj.moviematch.data.getComedyMovieJsonData
import com.suraj.moviematch.data.getHorrorMovieJsonData
import com.suraj.moviematch.data.getThrillerMovieJsonData
import com.suraj.moviematch.dataClasses.MovieReview
import com.suraj.moviematch.dataClasses.Shorts
import com.suraj.moviematch.db.MovieDao
import kotlinx.coroutines.tasks.await

class MoviesRepository(private val movieDao: MovieDao) {

    private val db = FirebaseFirestore.getInstance()

    private val shortsCollection = db.collection("shorts")

    fun getMoviesByFilter(filter: String): List<Movie> {
        val jsonData = when (filter) {
            "All" -> getAllMovieJsonData()
            "Action" -> getActionMovieJsonData()
            "Comedy" -> getComedyMovieJsonData()
            "Horror" -> getHorrorMovieJsonData()
            "Thriller" -> getThrillerMovieJsonData()
            "Adventure" -> getAdventureMovieJsonData()
            "Animation" -> getAnimationMovieJsonData()
            else -> getAllMovieJsonData()
        }

        val gson = Gson()
        val moviesData = gson.fromJson(jsonData, Movies::class.java)
        return moviesData.movies
    }


    suspend fun addReview(movieName: String, review: MovieReview) {
        val reviewData = hashMapOf(
            "userName" to review.user,
            "rating" to review.rating,
            "comments" to review.review
        )
        db.collection("reviews")
            .document(movieName)
            .collection("reviews")
            .add(reviewData)
            .await()
    }


    suspend fun getReviews(movieName: String): List<MovieReview> {
        val reviews = mutableListOf<MovieReview>()
        val querySnapshot = db.collection("reviews")
            .document(movieName)
            .collection("reviews")
            .get().await()
        for (document in querySnapshot) {
            val reviewData = document.data
            val review = MovieReview(
                review = reviewData["comments"] as? String,
                rating = (reviewData["rating"] as? Double)?.toFloat(),
                user = reviewData["userName"] as? String
            )
            reviews.add(review)
            Log.e("movieReviewList", "$review")
        }
        return reviews
    }


    suspend fun saveMovie(userUid: String, movie: Movie) {
        val savedMoviesCollection = db.collection("UserSavedData")
            .document(userUid)
            .collection("savedMovies")

        savedMoviesCollection.add(movie)
            .addOnSuccessListener {
                // Movie saved successfully
            }
            .addOnFailureListener { e ->
                // Handle error saving movie
            }
    }


    suspend fun getSavedMovies(userUid: String): List<Movie> {
        val savedMoviesCollection = db.collection("UserSavedData")
            .document(userUid)
            .collection("savedMovies")

        val querySnapshot = savedMoviesCollection.get().await()

        val savedMovies = mutableListOf<Movie>()
        for (document in querySnapshot) {
            val movie = document.toObject(Movie::class.java)
            savedMovies.add(movie)
        }

        return savedMovies
    }


    suspend fun deleteSavedMovieByName(userUid: String, movieName: String) {
        val savedMoviesCollection = db.collection("UserSavedData")
            .document(userUid)
            .collection("savedMovies")

        val querySnapshot = savedMoviesCollection.whereEqualTo("movieName", movieName).get().await()
        for (document in querySnapshot.documents) {
            document.reference.delete().await()
        }
    }


    suspend fun getAllMovies(): List<Movie> = movieDao.getAllMovies()

    suspend fun insertMovie(movie: Movie) = movieDao.insertMovie(movie)

    suspend fun deleteMovie(movie: Movie) = movieDao.deleteMovie(movie)


    fun addShort(short: Shorts) {
        shortsCollection.add(short)
    }


    fun getShorts(callback: (List<Shorts>) -> Unit) {
        shortsCollection.get()
            .addOnSuccessListener { querySnapshot ->
                val shortsList: MutableList<Shorts> = mutableListOf()
                for (document in querySnapshot) {
                    val short = document.toObject(Shorts::class.java)
                    shortsList.add(short)
                }

                // Reset random positions of list items
                shortsList.shuffle()

                callback(shortsList)
            }
            .addOnFailureListener { exception ->
                // Handle error
            }
    }


    suspend fun addMovieToHistory(movie: Movie) {
        db.collection("history")
            .add(movie)
            .addOnSuccessListener { documentReference ->
                Log.e("addMovieToHistory","$documentReference")
            }
            .addOnFailureListener { exception ->
                Log.e("addMovieToHistory","$exception")
            }
    }


    fun getHistory(): LiveData<List<Movie>?> {
        val historyLiveData = MutableLiveData<List<Movie>>()

        db.collection("history")
            .get()
            .addOnSuccessListener { querySnapshot ->
                val movies = mutableListOf<Movie>()
                for (document in querySnapshot) {
                    val movie = document.toObject(Movie::class.java)
                    movies.add(movie)
                }
                historyLiveData.value = movies
            }
            .addOnFailureListener { exception ->
                // Handle error
            }

        return historyLiveData
    }

  suspend  fun deleteMovieFromHistory(movie: Movie) {
        db.collection("history")
            .whereEqualTo("movieName", movie.movieName)
            .get()
            .addOnSuccessListener { querySnapshot ->
                for (document in querySnapshot) {
                    document.reference.delete()
                }
            }
            .addOnFailureListener { exception ->
                // Handle error
            }
    }


}