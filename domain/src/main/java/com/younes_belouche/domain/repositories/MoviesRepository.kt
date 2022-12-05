package com.younes_belouche.domain.repositories

import com.younes_belouche.domain.entities.Movie
import com.younes_belouche.domain.utils.Resource

interface MoviesRepository {
    suspend fun getTrendingMovies(): Resource<List<Movie>>;
    suspend fun getMovie(movieId : Long): Resource<Movie>;
}