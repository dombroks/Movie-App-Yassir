package com.younes_belouche.data.repositories


import com.younes_belouche.data.datasources.remote.MovieApiService
import com.younes_belouche.domain.entities.Movie
import com.younes_belouche.domain.repositories.MoviesRepository;
import com.younes_belouche.domain.utils.Resource

class MoviesRepositoryImp(
    private val moviesApiService: MovieApiService
) : MoviesRepository {
    override suspend fun getTrendingMovies(): Resource<List<Movie>> {
        val response = moviesApiService.getTrendingMovies();
        if (response.isSuccessful) {
            response.body()?.results.let {
                return Resource.success(
                    it?.map { it ->
                        Movie(
                            title = it.title,
                            id = it.id,
                            poster_path = it.posterPath as String,
                            overview = it.overview
                        )
                    }
                )
            }
        } else return Resource.error("Something went wrong", null);

    }

    override suspend fun getMovie(movieId: Long): Resource<Movie> {
        val response = moviesApiService.getMovie(movieId = movieId);
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.success(
                    Movie(
                        id = it.id,
                        title = it.title,
                        overview = it.overview,
                        poster_path = it.posterPath.toString()
                    )
                )
            }
        }
        return Resource.error("Something went wrong", null);
    }
}