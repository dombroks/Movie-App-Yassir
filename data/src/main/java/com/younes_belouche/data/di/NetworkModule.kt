package com.younes_belouche.data.di

import com.younes_belouche.data.datasources.remote.MovieApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Provides
    fun provideMovieApiService(
        // Potential dependencies of this type
    ): MovieApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .build()
            .create(MovieApiService::class.java)
    }

}