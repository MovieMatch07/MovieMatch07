package com.suraj.moviematch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.suraj.moviematch.dataClasses.Movie
import com.suraj.moviematch.dataClasses.MoviesSaved
import com.suraj.moviematch.databinding.RvMoviesLayout2Binding
import com.suraj.moviematch.databinding.RvMoviesLayoutBinding

class HistoryMoviesAdapter() :
    RecyclerView.Adapter<HistoryMoviesAdapter.ViewHolder>() {

    private val moviesList = ArrayList<Movie>()

    interface SetOnClickListener {
        fun onClick(movie: Movie)
    }

    var setOnClickListener: SetOnClickListener? = null

    inner class ViewHolder(private val binding: RvMoviesLayout2Binding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    setOnClickListener?.onClick(moviesList[position])
                }
            }
        }

        fun bind(movie: Movie) {
            binding.txtMovieName.text = movie.movieName
            Glide.with(binding.root.context).load(movie.imageUrl).into(binding.imgMovie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            RvMoviesLayout2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun addAll(moviesList2: List<Movie>) {
        moviesList.clear()
        moviesList.addAll(moviesList2)
        notifyDataSetChanged()
    }

}