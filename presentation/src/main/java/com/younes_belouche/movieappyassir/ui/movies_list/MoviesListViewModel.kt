package com.younes_belouche.movieappyassir.ui.movies_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.younes_belouche.domain.entities.Movie
import com.younes_belouche.domain.repositories.MoviesRepository
import com.younes_belouche.domain.usecases.GetTrendingMoviesUseCase
import com.younes_belouche.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {
    private val _moviesList =
        MutableLiveData<Resource<List<Movie>>>()
    val moviesList: LiveData<Resource<List<Movie>>>
        get() = _moviesList

    fun getMoviesList() {
        viewModelScope.launch {
            _moviesList.value = GetTrendingMoviesUseCase(moviesRepository).execute()
        }
    }

}