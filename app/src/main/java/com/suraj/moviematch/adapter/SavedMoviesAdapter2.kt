package com.suraj.moviematch.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.suraj.moviematch.dataClasses.Movie
import com.suraj.moviematch.databinding.SavedMoviesLayoutBinding

class SavedMovieAdapter2() :
    RecyclerView.Adapter<SavedMovieAdapter2.ViewHolder>() {

    private val moviesList = ArrayList<Movie>()

    interface SetOnClickListener {
        fun onClick(movie: Movie)

        fun onRemoveClick(movie: Movie)
    }

    var setOnClickListener: SetOnClickListener? = null

    inner class ViewHolder(private val binding: SavedMoviesLayoutBinding) :
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
//            Glide.with(binding.root.context).load(movie.imageUrl).into(binding.imgMovie)
            Picasso.get().load(movie.imageUrl).into(binding.imgMovie)
            binding.txtMovieCategory.text = "${movie.categories[0]}, ${movie.categories[1]}"
            Log.e("txtMovieNameUrl","${movie.imageUrl}")
            binding.btnMovieRemove.setOnClickListener {
             setOnClickListener?.onRemoveClick(movie)
            }

            binding.btnMoviePlay.setOnClickListener {
                setOnClickListener?.onClick(movie)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SavedMoviesLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = moviesList[position]

        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return  moviesList.size
    }

    fun addAll(moviesList2: List<Movie>) {
        moviesList.clear()
        moviesList.addAll(moviesList2)
        notifyDataSetChanged()
    }


}
