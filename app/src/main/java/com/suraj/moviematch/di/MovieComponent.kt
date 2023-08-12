package com.suraj.moviematch.di


import com.suraj.moviematch.activity.HomeActivity
import com.suraj.moviematch.activity.MovieDetailsActivity
import com.suraj.moviematch.activity.SearchActivity
import com.suraj.moviematch.fragments.ReviewsFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class])
interface MovieComponent {
    fun inject(homeActivity: HomeActivity)

    fun inject(movieDetailsActivity: MovieDetailsActivity)

    fun inject(reviewsFragment: ReviewsFragment)
    fun inject(searchActivity: SearchActivity)


}