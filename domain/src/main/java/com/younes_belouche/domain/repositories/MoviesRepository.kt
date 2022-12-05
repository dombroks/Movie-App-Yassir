package com.younes_belouche.domain.repositories

import com.younes_belouche.domain.models.Movie
import com.younes_belouche.domain.utils.Resource

interface MoviesRepository {
    suspend fun getTrendingMovies(): Resource<List<Movie>>;
    suspend fun getMovie(): Resource<Movie>;
}