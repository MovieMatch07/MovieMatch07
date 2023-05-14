package com.suraj.moviematch.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.suraj.moviematch.R
import com.suraj.moviematch.data.Movie

class MovieAdapter(private val movies: ArrayList<Movie>, var listCode: Int) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    interface SetOnClickListener {
        fun onClick(
            movie: Movie
        )
    }

    var setOnClickListener: SetOnClickListener? = null


    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        lateinit var imgMovie: ImageView
        lateinit var mainContainer: LinearLayout
        lateinit var moviesLayout: LinearLayout

        lateinit var txtMovieName: TextView

        init {

            imgMovie = view.findViewById(R.id.imgMovie)
            txtMovieName = view.findViewById(R.id.txtMovieName)
            mainContainer = view.findViewById(R.id.mainContainer)
            moviesLayout = view.findViewById(R.id.moviesLayout)


            view.setOnClickListener {
                setOnClickListener?.onClick(movies[adapterPosition])
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_movies_layout, null)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val movie = movies[position]

        holder.txtMovieName.text = movie.movieName

        Glide.with(holder.view.context).load(movie.imageUrl).into(holder.imgMovie)

    }

    override fun getItemCount(): Int {
        if (listCode == 0) return movies.size - 1

        else return movies.size

    }

}
