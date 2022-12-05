package com.younes_belouche.domain.usecases

import com.younes_belouche.domain.entities.Movie
import com.younes_belouche.domain.repositories.MoviesRepository
import com.younes_belouche.domain.utils.Resource

class GetTrendingMoviesUseCase(
    private val moviesRepository: MoviesRepository
) {
    suspend operator fun invoke(): Resource<List<Movie>> {
        return moviesRepository.getTrendingMovies();
    }
}