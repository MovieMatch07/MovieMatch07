package com.suraj.moviematch.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.suraj.moviematch.adapter.ReviewAdapter
import com.suraj.moviematch.dataClasses.MovieReview
import com.suraj.moviematch.databinding.FragmentReviewsBinding
import com.suraj.moviematch.dialogs.AddReviewDialog

class ReviewsFragment : Fragment() {

    private lateinit var binding: FragmentReviewsBinding
    private var movieName = ""
    private var movieReviewList = ArrayList<MovieReview>()
    private lateinit var reviewAdapter : ReviewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReviewsBinding.inflate(inflater, container, false)

        val bundle = arguments
        movieName = bundle?.getString("MovieName").toString()

        getMovieReviewList()

        setUpListener()
        return binding.root
    }



    private fun setUpListener() {
        binding.btnAddReview.setOnClickListener {
            val addReviewDialog = AddReviewDialog(requireContext(), movieName)
            addReviewDialog.show()
        }
    }

    private fun getMovieReviewList() {
        val databaseReference =
            FirebaseDatabase.getInstance().reference.child("reviews").child(movieName)

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                movieReviewList.clear()

                for (snapshot in dataSnapshot.children) {
                    val movieReview = snapshot.getValue(MovieReview::class.java)

                    if (movieReview != null) {
                        movieReviewList.add(movieReview)
                    }

                }

                reviewAdapter = ReviewAdapter(movieReviewList)

                binding.rvMovieReview.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

                binding.rvMovieReview.adapter = reviewAdapter

                if (movieReviewList.isEmpty())
                {
                    binding.txtListEmpty.visibility = View.VISIBLE
                    binding.rvMovieReview.visibility = View.GONE
                } else
                {
                    binding.txtListEmpty.visibility = View.GONE
                    binding.rvMovieReview.visibility = View.VISIBLE
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(requireContext(), "Error while Reading Reviews Data", Toast.LENGTH_SHORT).show()
            }
        })
    }



}
