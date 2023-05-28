package com.suraj.moviematch.activity

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
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

class HomeActivity : AppCompatActivity() {

    private lateinit var rvHomeActivity: RecyclerView

    private lateinit var toolbar: Toolbar

    private lateinit var txt_filterAll: TextView

    private lateinit var txt_filterAction: TextView
    private lateinit var txt_filterComedy: TextView
    private lateinit var txt_filterHorror: TextView
    private lateinit var txt_filterThriller: TextView
    private lateinit var txt_filterAdventure: TextView
    private lateinit var txt_filterAnimation: TextView
    private lateinit var txt_filterSaved: TextView
    private lateinit var btn_Search: ImageButton

    private lateinit var movieAdapter: MovieAdapter

    lateinit var layoutManager: StaggeredGridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initview()

        loadMoviesDataInRecyclerView("All")

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        setOnCLick()


    }

    private fun initview() {

        toolbar = findViewById<Toolbar>(R.id.custom_toolbar)

        txt_filterAll = findViewById<TextView>(R.id.txt_filterAll)
        txt_filterAction = findViewById<TextView>(R.id.txt_filterAction)
        txt_filterComedy = findViewById<TextView>(R.id.txt_filterComedy)
        txt_filterHorror = findViewById<TextView>(R.id.txt_filterHorror)
        txt_filterThriller = findViewById<TextView>(R.id.txt_filterThriller)
        txt_filterAdventure = findViewById<TextView>(R.id.txt_filterAdventure)
        txt_filterAnimation = findViewById<TextView>(R.id.txt_filterAnimation)
        txt_filterSaved = findViewById<TextView>(R.id.txt_filterSaved)
        btn_Search = findViewById<ImageButton>(R.id.btn_Search)

        rvHomeActivity = findViewById<RecyclerView>(R.id.rvHomeActivity)

    }


    private fun setOnCLick() {

        val onClickListener = OnClickListener()
        txt_filterAll.setOnClickListener(onClickListener)
        txt_filterAction.setOnClickListener(onClickListener)
        txt_filterComedy.setOnClickListener(onClickListener)
        txt_filterHorror.setOnClickListener(onClickListener)
        txt_filterThriller.setOnClickListener(onClickListener)
        txt_filterAdventure.setOnClickListener(onClickListener)
        txt_filterAnimation.setOnClickListener(onClickListener)
        txt_filterSaved.setOnClickListener(onClickListener)


        btn_Search.setOnClickListener {

            val intent = Intent(this@HomeActivity, SearchActivity::class.java)
            startActivity(intent)

        }

    }

    private inner class OnClickListener : View.OnClickListener {
        override fun onClick(view: View?) {


            when (view!!.id) {

                R.id.txt_filterAll -> {
                    loadMoviesDataInRecyclerView("All")
                }


                R.id.txt_filterAction -> {
                    loadMoviesDataInRecyclerView("Action")

                }

                R.id.txt_filterComedy -> {
                    loadMoviesDataInRecyclerView("Comedy")

                }

                R.id.txt_filterHorror -> {
                    loadMoviesDataInRecyclerView("Horror")

                }

                R.id.txt_filterThriller -> {
                    loadMoviesDataInRecyclerView("Thriller")
                }

                R.id.txt_filterAdventure -> {
                    loadMoviesDataInRecyclerView("Adventure")
                }

                R.id.txt_filterAnimation -> {
                    loadMoviesDataInRecyclerView("Animation")
                }

                R.id.txt_filterSaved -> {
                    loadMoviesDataInRecyclerView("Saved")
                }
            }
            movieAdapter.notifyDataSetChanged()
        }
    }

    private fun loadMoviesDataInRecyclerView(filter: String): ArrayList<Movie> {

        var movieList = ArrayList<Movie>()
        val gson = Gson()

        val orientation = resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            layoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
        } else {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }

        setupUi(filter)
        when (filter) {
            "All" -> {
                movieList = gson.fromJson(
                    getAllMovieJsonData(),
                    Movies::class.java
                ).movies as ArrayList<Movie>


                rvHomeActivity.layoutManager = layoutManager

                movieAdapter = MovieAdapter(movieList, 0)

                rvHomeActivity.adapter = movieAdapter
            }

            "Action" -> {
                movieList = gson.fromJson(
                    getActionMovieJsonData(),
                    Movies::class.java
                ).movies as ArrayList<Movie>

                rvHomeActivity.layoutManager = layoutManager
                movieAdapter = MovieAdapter(movieList, 0)

                rvHomeActivity.adapter = movieAdapter

            }

            "Comedy" -> {
                movieList = gson.fromJson(
                    getComedyMovieJsonData(),
                    Movies::class.java
                ).movies as ArrayList<Movie>



                rvHomeActivity.layoutManager = layoutManager

                movieAdapter = MovieAdapter(movieList, 0)

                rvHomeActivity.adapter = movieAdapter

            }

            "Horror" -> {
                movieList = gson.fromJson(
                    getHorrorMovieJsonData(),
                    Movies::class.java
                ).movies as ArrayList<Movie>



                rvHomeActivity.layoutManager = layoutManager

                movieAdapter = MovieAdapter(movieList, 0)

                rvHomeActivity.adapter = movieAdapter

            }

            "Thriller" -> {
                movieList = gson.fromJson(
                    getThrillerMovieJsonData(),
                    Movies::class.java
                ).movies as ArrayList<Movie>



                rvHomeActivity.layoutManager = layoutManager

                movieAdapter = MovieAdapter(movieList, 0)

                rvHomeActivity.adapter = movieAdapter

            }

            "Adventure" -> {
                movieList = gson.fromJson(
                    getAdventureMovieJsonData(),
                    Movies::class.java
                ).movies as ArrayList<Movie>


                rvHomeActivity.layoutManager = layoutManager

                movieAdapter = MovieAdapter(movieList, 0)

                rvHomeActivity.adapter = movieAdapter

            }

            "Animation" -> {
                movieList = gson.fromJson(
                    getAnimationMovieJsonData(),
                    Movies::class.java
                ).movies as ArrayList<Movie>


                rvHomeActivity.layoutManager = layoutManager

                movieAdapter = MovieAdapter(movieList, 0)

                rvHomeActivity.adapter = movieAdapter

            }


            "Saved" -> {

                movieList.clear()



                movieList =  getSavedMovies()
//                Log.e("MyData",movieList[1].movieName.toString())

                rvHomeActivity.layoutManager = layoutManager

                movieAdapter = MovieAdapter(movieList, 0)

                rvHomeActivity.adapter = movieAdapter

            }

        }

        movieAdapter.setOnClickListener = SetOnClick()

        return movieList
    }

    private fun getSavedMovies(): ArrayList<Movie> {
// Get the user ID of the current user
        val userId = FirebaseAuth.getInstance().currentUser?.uid

// Create a reference to the location where the data is stored

       var movieList2 = ArrayList<Movie>()

        val userRef = FirebaseDatabase.getInstance().reference.child("usersSaveData").child(userId.toString())

// Add a ValueEventListener to listen for changes in the data
        userRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called whenever the data at the location changes

                // Clear the existing list to avoid duplicates


                // Iterate through each child snapshot to retrieve individual entries
                for (snapshot in dataSnapshot.children) {
                    // Retrieve the movieData for each entry
                    val movieData = snapshot.getValue(Movie::class.java)

                    if (movieData != null) {
                        movieList2.add(movieData)
                    }
                    Log.e("MyData",movieData?.movieName.toString())
                    // Add the movieData to the ArrayList
                    movieData?.let { movieList2.add(it) }
                }

                // Perform any operations with the updated movieDataList
                // ...
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // This method is called if the ValueEventListener is canceled
                // Handle any errors or interruptions here
            }
        })

        return movieList2

    }

    private fun setupUi(selectFilter: String) {

        setBackgroundUnselected()

        when (selectFilter) {

            "All" -> {
                txt_filterAll.setTextColor(resources.getColor(R.color.red))
                txt_filterAll.setBackgroundColor(resources.getColor(R.color.white))
            }

            "Action" -> {
                txt_filterAction.setTextColor(resources.getColor(R.color.red))
                txt_filterAction.setBackgroundColor(resources.getColor(R.color.white))
            }

            "Comedy" -> {
                txt_filterComedy.setTextColor(resources.getColor(R.color.red))
                txt_filterComedy.setBackgroundColor(resources.getColor(R.color.white))
            }

            "Horror" -> {
                txt_filterHorror.setTextColor(resources.getColor(R.color.red))
                txt_filterHorror.setBackgroundColor(resources.getColor(R.color.white))
            }

            "Thriller" -> {
                txt_filterThriller.setTextColor(resources.getColor(R.color.red))
                txt_filterThriller.setBackgroundColor(resources.getColor(R.color.white))
            }

            "Adventure" -> {
                txt_filterAdventure.setTextColor(resources.getColor(R.color.red))
                txt_filterAdventure.setBackgroundColor(resources.getColor(R.color.white))
            }

            "Animation" -> {
                txt_filterAnimation.setTextColor(resources.getColor(R.color.red))
                txt_filterAnimation.setBackgroundColor(resources.getColor(R.color.white))
            }

            "Saved" -> {
                txt_filterSaved.setTextColor(resources.getColor(R.color.red))
                txt_filterSaved.setBackgroundColor(resources.getColor(R.color.white))
            }
        }
    }


    private fun setBackgroundUnselected() {

        txt_filterAll.setTextColor(resources.getColor(R.color.white))
        txt_filterAll.setBackgroundColor(resources.getColor(R.color.purpleLight))

        txt_filterAction.setTextColor(resources.getColor(R.color.white))
        txt_filterAction.setBackgroundColor(resources.getColor(R.color.purpleLight))

        txt_filterComedy.setTextColor(resources.getColor(R.color.white))
        txt_filterComedy.setBackgroundColor(resources.getColor(R.color.purpleLight))

        txt_filterHorror.setTextColor(resources.getColor(R.color.white))
        txt_filterHorror.setBackgroundColor(resources.getColor(R.color.purpleLight))

        txt_filterThriller.setTextColor(resources.getColor(R.color.white))
        txt_filterThriller.setBackgroundColor(resources.getColor(R.color.purpleLight))

        txt_filterAdventure.setTextColor(resources.getColor(R.color.white))
        txt_filterAdventure.setBackgroundColor(resources.getColor(R.color.purpleLight))

        txt_filterAnimation.setTextColor(resources.getColor(R.color.white))
        txt_filterAnimation.setBackgroundColor(resources.getColor(R.color.purpleLight))

        txt_filterSaved.setTextColor(resources.getColor(R.color.white))
        txt_filterSaved.setBackgroundColor(resources.getColor(R.color.purpleLight))

    }


    inner class SetOnClick : MovieAdapter.SetOnClickListener {
        override fun onClick(movie: Movie) {
            val intent = Intent(this@HomeActivity, MovieDetailsActivity::class.java)
            intent.putExtra("movie", movie)
            startActivity(intent)
            finish()

        }
    }


}