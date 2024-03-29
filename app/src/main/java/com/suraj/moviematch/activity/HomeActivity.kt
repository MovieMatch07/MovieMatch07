package com.suraj.moviematch.activity

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.suraj.moviematch.R
import com.suraj.moviematch.adapter.MovieAdapter
import com.suraj.moviematch.app.MyApplication
import com.suraj.moviematch.dataClasses.Movie
import com.suraj.moviematch.databinding.ActivityHomeBinding
import com.suraj.moviematch.repository.MoviesRepository
import com.suraj.moviematch.viewModel.MovieViewModel
import com.suraj.moviematch.viewModel.MovieViewModelFactory
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private lateinit var navController: NavController

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.let { ViewPumpContextWrapper.wrap(it) })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        (application as MyApplication).movieComponent.inject(this)


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        bottomNavigationView.setupWithNavController(navController)

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    navController.popBackStack()
                    navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.navigation_Trending -> {
                    // Handle Search tab click
                    navController.popBackStack()
                    navController.navigate(R.id.trendingFragment)
                    true
                }

                R.id.navigation_Library -> {
                    // Handle Search tab click
                    navController.popBackStack()
                    navController.navigate(R.id.libraryFragment)
                    true
                }

                // Add more cases for other menu items
                else -> false
            }
        }
    }
    private fun showQuitConfirmationDialog() {
        val builder = AlertDialog.Builder(this@HomeActivity)
        builder.setTitle("Quit")
        builder.setMessage("Are you sure you want to quit the app?")
        builder.setPositiveButton("Quit") { dialogInterface: DialogInterface, i: Int ->
           finish()
        }
        builder.setNegativeButton("Cancel", null)
        builder.show()
    }

    override fun onBackPressed() {
        showQuitConfirmationDialog()
    }

}
