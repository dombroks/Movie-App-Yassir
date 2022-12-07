package com.younes_belouche.domain.usecases

import com.younes_belouche.domain.entities.Movie
import com.younes_belouche.domain.repositories.MoviesRepository
import com.younes_belouche.domain.utils.Resource

class GetTrendingMoviesUseCase(
    private val moviesRepository: MoviesRepository
) {
    suspend fun execute(): Resource<List<Movie>> {
        return moviesRepository.getTrendingMovies();
    }
}