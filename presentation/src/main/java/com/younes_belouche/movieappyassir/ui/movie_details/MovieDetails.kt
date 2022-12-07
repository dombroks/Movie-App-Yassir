package com.younes_belouche.movieappyassir.ui.movie_details

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.younes_belouche.movieappyassir.R
import com.younes_belouche.movieappyassir.databinding.FragmentMovieDetailsBinding
import com.younes_belouche.movieappyassir.databinding.FragmentMoviesListBinding
import com.younes_belouche.movieappyassir.ui.movies_list.MovieAdapter
import com.younes_belouche.movieappyassir.ui.movies_list.MoviesListViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate

@AndroidEntryPoint
class MovieDetails : Fragment() {

    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MovieDetailsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieId = arguments?.getLong("movieId")!!

        viewModel.getMovie(movieId)
        viewModel.movie.observe(
            viewLifecycleOwner
        ) {
            binding.apply {
                Glide.with(this.poster.context)
                    .load(
                        "https://image.tmdb.org/t/p/w500/" + (it.data?.poster_path
                            ?: "kqjL17yufvn9OVLyXYpvtyrFfak.jpg")
                    )
                    .into(this.poster)
                this.overview.text = it.data?.overview
                this.title.text = it.data?.title
                this.year.text = LocalDate.parse(it.data?.year).year.toString()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


}