package com.younes_belouche.movieappyassir.ui.movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.younes_belouche.domain.entities.Movie
import com.younes_belouche.domain.repositories.MoviesRepository
import com.younes_belouche.domain.usecases.GetMovieUseCase
import com.younes_belouche.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {
    private val _movie =
        MutableLiveData<Resource<Movie>>()
    val movie: LiveData<Resource<Movie>>
        get() = _movie

    fun getMovie(movieId : Long) {
        viewModelScope.launch {
            _movie.value = GetMovieUseCase(moviesRepository).execute(movieId)
        }
    }
}