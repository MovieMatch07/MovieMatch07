package com.suraj.moviematch.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.suraj.moviematch.R
import com.suraj.moviematch.activity.MovieDetailsActivity
import com.suraj.moviematch.activity.SearchActivity
import com.suraj.moviematch.adapter.MovieAdapter
import com.suraj.moviematch.app.MyApplication
import com.suraj.moviematch.dataClasses.Movie
import com.suraj.moviematch.databinding.ActivityHomeBinding
import com.suraj.moviematch.databinding.FragmentHomeBinding
import com.suraj.moviematch.repository.MoviesRepository
import com.suraj.moviematch.viewModel.MovieViewModel
import com.suraj.moviematch.viewModel.MovieViewModelFactory
import javax.inject.Inject


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var layoutManager: StaggeredGridLayoutManager
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var selectedFilterTextView: View

    @Inject
    lateinit var movieRepository: MoviesRepository

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)


        (requireActivity().application as MyApplication).movieComponent.inject(this)


//        setSupportActionBar(binding.customToolbar)
//        supportActionBar?.setDisplayShowTitleEnabled(false)

        initViews()
        setOnClick()
        setUpViewModel()

        movieViewModel.loadMoviesByFilter("All")
        selectedFilterTextView = binding.txtFilterAll
        selectFilterTextView(selectedFilterTextView)


      binding.swipeRefreshLayout.setOnRefreshListener {
            refreshData()
        }

        return binding.root
    }

    private fun refreshData() {
        movieViewModel.loadMoviesByFilter("All")
        selectedFilterTextView = binding.txtFilterAll
        selectFilterTextView(selectedFilterTextView)
       binding. swipeRefreshLayout.isRefreshing = false

    }

    private fun initViews() {

        movieViewModel = ViewModelProvider(this, movieViewModelFactory).get(MovieViewModel::class.java)
        layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rvHomeActivity.layoutManager = layoutManager
        movieAdapter = MovieAdapter(0)
        binding.rvHomeActivity.adapter = movieAdapter
        movieAdapter.setOnClickListener = SetOnClick()
    }


    private fun setOnClick() {
        val onClickListener = OnClickListener()
        binding.txtFilterAll.setOnClickListener(onClickListener)
        binding.txtFilterAction.setOnClickListener(onClickListener)
        binding.txtFilterComedy.setOnClickListener(onClickListener)
        binding.txtFilterHorror.setOnClickListener(onClickListener)
        binding.txtFilterThriller.setOnClickListener(onClickListener)
        binding.txtFilterAdventure.setOnClickListener(onClickListener)
        binding.txtFilterAnimation.setOnClickListener(onClickListener)
        binding.txtFilterSaved.setOnClickListener(onClickListener)

        binding.btnSearch.setOnClickListener {
            val intent = Intent(requireContext(), SearchActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

    }


    private inner class OnClickListener : View.OnClickListener {
        override fun onClick(view: View?) {

            movieAdapter.listCode(0)
            val previousSelectedFilterTextView = selectedFilterTextView
            selectedFilterTextView = view ?: binding.txtFilterAll
            selectFilterTextView(selectedFilterTextView)

            when (selectedFilterTextView.id) {
                R.id.txt_filterAll -> movieViewModel.loadMoviesByFilter("All")
                R.id.txt_filterAction -> movieViewModel.loadMoviesByFilter("Action")
                R.id.txt_filterComedy -> movieViewModel.loadMoviesByFilter("Comedy")
                R.id.txt_filterHorror -> movieViewModel.loadMoviesByFilter("Horror")
                R.id.txt_filterThriller -> movieViewModel.loadMoviesByFilter("Thriller")
                R.id.txt_filterAdventure -> movieViewModel.loadMoviesByFilter("Adventure")
                R.id.txt_filterAnimation -> movieViewModel.loadMoviesByFilter("Animation")
                R.id.txt_filterSaved -> getSavedMovies()
            }
        }
    }

    private fun getSavedMovies() {


        movieViewModel.movieSavedList.observe(this){
            if (it != null) {
                movieAdapter.listCode(1)
                movieAdapter.addAll(it)
            }
        }

        movieViewModel.getAllMovies()


    }

    private fun setUpViewModel() {
        movieViewModel.movieList.observe(viewLifecycleOwner) {
            movieAdapter.addAll(it)
        }
    }

    private fun selectFilterTextView(textView: View) {
        val unselectedTextViews = listOf(
            binding.txtFilterAll, binding.txtFilterAction, binding.txtFilterComedy,
            binding.txtFilterHorror, binding.txtFilterThriller, binding.txtFilterAdventure,
            binding.txtFilterAnimation, binding.txtFilterSaved
        )

        for (unselectedTextView in unselectedTextViews) {
            unselectedTextView.setBackgroundResource(R.color.purpleLight)
            unselectedTextView.isSelected = false
            unselectedTextView.setTextColor(resources.getColor(R.color.white))
        }

        textView.setBackgroundResource(R.color.white)
        textView.isSelected = true
        (textView as? TextView)?.setTextColor(resources.getColor(R.color.red))
    }

    inner class SetOnClick : MovieAdapter.SetOnClickListener {
        override fun onClick(movie: Movie) {
            val intent = Intent(requireContext(), MovieDetailsActivity::class.java)
            intent.putExtra("movie", movie)
            startActivity(intent)
            requireActivity().finish()
        }
    }



}