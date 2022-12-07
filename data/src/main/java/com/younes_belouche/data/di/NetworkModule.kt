package com.younes_belouche.data.di

import com.younes_belouche.data.datasources.remote.MovieApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Provides
    fun provideMovieApiService(
        // Potential dependencies of this type
    ): MovieApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.themoviedb.org/3/")
            .build()
            .create(MovieApiService::class.java)
    }

}