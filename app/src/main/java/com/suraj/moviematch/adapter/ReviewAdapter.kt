package com.suraj.moviematch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.suraj.moviematch.R
import com.suraj.moviematch.dataClasses.MovieReview

class ReviewAdapter(val movieReviewList: ArrayList<MovieReview>) :
    RecyclerView.Adapter<ReviewAdapter.ReviewHolder>() {


    inner class ReviewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        lateinit var ratingBar: RatingBar
        lateinit var txtReview: TextView
        lateinit var txtUser: TextView

        init {

            ratingBar = view.findViewById(R.id.ratingBar)
            txtReview = view.findViewById(R.id.txtMovieReview)
            txtUser = view.findViewById(R.id.txtMovieReviewUser)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_review_layout, parent, false)
        return ReviewHolder(view)
    }

    override fun getItemCount() = movieReviewList.size

    override fun onBindViewHolder(holder: ReviewHolder, position: Int) {

        holder.ratingBar.rating = movieReviewList[position].rating?.toFloat()!!

        val data = movieReviewList[position]

        holder.txtUser.text = data.user.toString()

        holder.txtReview.text = data.review.toString()

    }


}