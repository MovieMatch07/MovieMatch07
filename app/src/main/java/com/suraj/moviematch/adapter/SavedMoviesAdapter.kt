package com.suraj.moviematch.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.suraj.moviematch.dataClasses.MoviesSaved

class SavedMoviesAdapter(val movieList : ArrayList<MoviesSaved>) : RecyclerView.Adapter<SavedMoviesAdapter.MovieHolder>() {

     class MovieHolder(val view : View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        TODO("Not yet implemented")
    }

}