package com.younes_belouche.data.datasources.remote

import com.younes_belouche.data.models.Result
import com.younes_belouche.data.models.Trending
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    @GET("discover/movie")
    suspend fun getTrendingMovies(
        @Query("api_key") apiKey: String = "c9856d0cb57c3f14bf75bdc6c063b8f3"
    ): Response<Trending>

    @GET("movie/{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") movieId: Long? = 1L,
        @Query("api_key") apiKey: String = "c9856d0cb57c3f14bf75bdc6c063b8f3"
    ): Response<Result>
}