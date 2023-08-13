package com.suraj.moviematch.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.suraj.moviematch.activity.SearchActivity
import com.suraj.moviematch.adapter.VideoAdapter
import com.suraj.moviematch.app.MyApplication
import com.suraj.moviematch.databinding.FragmentTrendingBinding
import com.suraj.moviematch.repository.MoviesRepository
import com.suraj.moviematch.viewModel.MovieViewModel
import com.suraj.moviematch.viewModel.MovieViewModelFactory
import javax.inject.Inject


class TrendingFragment : Fragment() {

    private lateinit var binding: FragmentTrendingBinding

    lateinit var movieViewModel: MovieViewModel

    @Inject
    lateinit var movieRepository: MoviesRepository

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory

    lateinit var videoAdapter: VideoAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrendingBinding.inflate(inflater)

        (requireActivity().application as MyApplication).movieComponent.inject(this)

        movieViewModel =
            ViewModelProvider(viewModelStore, movieViewModelFactory).get(MovieViewModel::class.java)


        videoAdapter = VideoAdapter()

        binding.MainViewPager.adapter = videoAdapter


        movieViewModel.shortsLiveData.observe(viewLifecycleOwner) { shortsList ->

            videoAdapter.addAll(shortsList)
            Log.e("shortsLiveData", "$shortsList")

        }

        movieViewModel.getShorts()


        setOnClick()


        return binding.root
    }

    private fun setOnClick() {
        binding.btnSearch.setOnClickListener {
            val intent = Intent(requireContext(), SearchActivity::class.java)
            startActivity(intent)
        }
    }

}