package com.suraj.moviematch.di


import com.suraj.moviematch.activity.HistoryActivity
import com.suraj.moviematch.activity.HomeActivity
import com.suraj.moviematch.activity.MovieDetailsActivity
import com.suraj.moviematch.activity.SavedActivity
import com.suraj.moviematch.activity.SearchActivity
import com.suraj.moviematch.fragments.HomeFragment
import com.suraj.moviematch.fragments.LibraryFragment
import com.suraj.moviematch.fragments.ReviewsFragment
import com.suraj.moviematch.fragments.TrendingFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class])
interface MovieComponent {
    fun inject(homeActivity: HomeActivity)

    fun inject(movieDetailsActivity: MovieDetailsActivity)

    fun inject(reviewsFragment: ReviewsFragment)
    fun inject(homeFragment: HomeFragment)
    fun inject(trendingFragment: TrendingFragment)
    fun inject(libraryFragment: LibraryFragment)
    fun inject(savedActivity: SavedActivity)
    fun inject(historyActivity: HistoryActivity)
    fun inject(searchActivity: SearchActivity)


}