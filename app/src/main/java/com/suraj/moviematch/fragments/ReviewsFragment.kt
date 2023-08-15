package com.suraj.moviematch.fragments

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.suraj.moviematch.R
import com.suraj.moviematch.adapter.ReviewAdapter
import com.suraj.moviematch.app.MyApplication
import com.suraj.moviematch.dataClasses.MovieReview
import com.suraj.moviematch.databinding.FragmentReviewsBinding
import com.suraj.moviematch.dialogs.AddReviewDialog
import com.suraj.moviematch.repository.MoviesRepository
import com.suraj.moviematch.viewModel.MovieViewModel
import com.suraj.moviematch.viewModel.MovieViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class ReviewsFragment : Fragment() {

    private lateinit var binding: FragmentReviewsBinding
    private var movieName = ""
    private var movieReviewList = ArrayList<MovieReview>()
    private lateinit var reviewAdapter: ReviewAdapter
    private lateinit var movieViewModel: MovieViewModel
    @Inject
    lateinit var movieRepository: MoviesRepository

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReviewsBinding.inflate(inflater, container, false)

        (requireActivity().application as MyApplication).movieComponent.inject(this)

        initViewModel()

        val bundle = arguments
        movieName = bundle?.getString("MovieName").toString()

        // Initialize the adapter and layout manager
        reviewAdapter = ReviewAdapter(movieReviewList)
        binding.rvMovieReview.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvMovieReview.adapter = reviewAdapter

        setUpListener()
        getReviewsFromFirestore(movieName)
        return binding.root
    }

    private fun initViewModel() {

        movieViewModel = ViewModelProvider(this, movieViewModelFactory).get(MovieViewModel::class.java)
    }

    private fun setUpListener() {
        binding.btnAddReview.setOnClickListener {
            val addReviewDialog = AddReviewDialog(requireContext(), movieName,movieViewModel)
            addReviewDialog.show()
        }
    }




    private fun getReviewsFromFirestore(movieName: String) {
        CoroutineScope(Dispatchers.Main).launch {


            movieViewModel.movieReviewList.observe(viewLifecycleOwner) {
                if (it != null) {
                    movieReviewList.clear()
                    movieReviewList.addAll(it)

                    Log.e("movieReviewList","$it")

                }

                if (movieReviewList.isEmpty()) {
                    binding.txtListEmpty.visibility = View.VISIBLE
                    binding.rvMovieReview.visibility = View.GONE
                } else {
                    binding.txtListEmpty.visibility = View.GONE
                    binding.rvMovieReview.visibility = View.VISIBLE
                }

            }

            movieViewModel.getReviews(movieName)
        }
    }



}
