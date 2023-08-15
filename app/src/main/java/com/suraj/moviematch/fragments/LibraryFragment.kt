package com.suraj.moviematch.fragments

import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.window.SplashScreen
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.suraj.moviematch.R
import com.suraj.moviematch.activity.HistoryActivity
import com.suraj.moviematch.activity.MovieDetailsActivity
import com.suraj.moviematch.activity.SavedActivity
import com.suraj.moviematch.activity.SearchActivity
import com.suraj.moviematch.activity.loginActivity
import com.suraj.moviematch.adapter.HistoryMoviesAdapter
import com.suraj.moviematch.adapter.MovieAdapter
import com.suraj.moviematch.adapter.SavedMovieAdapter
import com.suraj.moviematch.app.MyApplication
import com.suraj.moviematch.dataClasses.Movie
import com.suraj.moviematch.databinding.FragmentLibraryBinding
import com.suraj.moviematch.repository.MoviesRepository
import com.suraj.moviematch.viewModel.MovieViewModel
import com.suraj.moviematch.viewModel.MovieViewModelFactory
import javax.inject.Inject

class LibraryFragment : Fragment() {

    private lateinit var binding: FragmentLibraryBinding
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movieAdapter: SavedMovieAdapter
    private lateinit var historyMoviesAdapter: HistoryMoviesAdapter

    @Inject
    lateinit var movieRepository: MoviesRepository

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLibraryBinding.inflate(inflater)

        (requireActivity().application as MyApplication).movieComponent.inject(this)

        initViews()

        getSavedMovies()

        return binding.root

    }



    private fun initViews() {

        movieViewModel =
            ViewModelProvider(this, movieViewModelFactory).get(MovieViewModel::class.java)
        binding.rvSavedList.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        movieAdapter = SavedMovieAdapter()
        binding.rvSavedList.adapter = movieAdapter
        movieAdapter.setOnClickListener = SetOnClick()


        binding.rvHistoryList.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        historyMoviesAdapter = HistoryMoviesAdapter()
        binding.rvHistoryList.adapter = historyMoviesAdapter
        historyMoviesAdapter.setOnClickListener = SetOnClick2()

        binding.textUserEmail.text = FirebaseAuth.getInstance().currentUser?.email.toString()
        binding.imgLogout.setOnClickListener {
            showLogoutConfirmationDialog()
        }

        binding.btnSearch.setOnClickListener {
            val intent = Intent(requireContext(), SearchActivity::class.java)
            startActivity(intent)
        }

        binding.txtSavedViewAll.setOnClickListener {
            val intent = Intent(requireContext(), SavedActivity::class.java)
            startActivity(intent)
        }

        binding.txtHistoryViewAll.setOnClickListener {
            val intent = Intent(requireContext(), HistoryActivity::class.java)
            startActivity(intent)
        }

    }


    private fun getSavedMovies() {

        movieViewModel.movieSavedList.observe(viewLifecycleOwner) {
            if (it != null) {
                movieAdapter.addAll(it)
            }
        }

        movieViewModel.getAllMovies()


        movieViewModel.historyList.observe(viewLifecycleOwner) {
            if (it != null) {
                historyMoviesAdapter.addAll(it)
            }
        }

    }



    private fun showLogoutConfirmationDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Logout")
        builder.setMessage("Are you sure you want to log out?")
        builder.setPositiveButton("Log Out") { dialogInterface: DialogInterface, i: Int ->
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(requireContext(), loginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
        builder.setNegativeButton("Cancel", null)
        builder.show()
    }

    inner class SetOnClick : SavedMovieAdapter.SetOnClickListener {
        override fun onClick(movie: Movie) {
            val intent = Intent(requireContext(), MovieDetailsActivity::class.java)
            intent.putExtra("movie", movie)
            startActivity(intent)
        }
    }


    inner class SetOnClick2 : HistoryMoviesAdapter.SetOnClickListener {
        override fun onClick(movie: Movie) {
            val intent = Intent(requireContext(), MovieDetailsActivity::class.java)
            intent.putExtra("movie", movie)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        movieViewModel.refreshHistoryList()
    }

}