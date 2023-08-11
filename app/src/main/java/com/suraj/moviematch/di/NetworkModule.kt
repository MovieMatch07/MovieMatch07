package com.suraj.moviematch.di

import android.content.Context
import androidx.room.Room
import com.suraj.moviematch.db.MovieDao
import com.suraj.moviematch.db.MovieDatabase
import com.suraj.moviematch.repository.MoviesRepository
import com.suraj.moviematch.viewModel.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class NetworkModule(private var context: Context) {

    @Singleton
    @Provides
    fun providesRepository(recipeDao: MovieDao): MoviesRepository {
        return MoviesRepository(recipeDao)
    }


    @Singleton
    @Provides
    fun provideRecipeDao(recipeDatabase: MovieDatabase): MovieDao {
        return recipeDatabase.movieDao()
    }


    @Provides
    @Singleton
    fun provideRecipeDatabase(context: Context): MovieDatabase {
        return Room.databaseBuilder(context, MovieDatabase::class.java, "movieDB")
            .build()
    }

    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }

    @Singleton
    @Provides
    fun provideViewModelFactory(repository: MoviesRepository): MovieViewModelFactory {
        return MovieViewModelFactory(repository)
    }

}