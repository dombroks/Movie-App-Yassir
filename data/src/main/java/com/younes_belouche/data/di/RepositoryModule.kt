package com.younes_belouche.data.di

import com.younes_belouche.data.datasources.remote.MovieApiService
import com.younes_belouche.data.repositories.MoviesRepositoryImp
import com.younes_belouche.domain.repositories.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Provides
    fun provideMoviesRepository(
        movieApiService: MovieApiService
    ): MoviesRepository {
        return MoviesRepositoryImp(movieApiService)
    }

}