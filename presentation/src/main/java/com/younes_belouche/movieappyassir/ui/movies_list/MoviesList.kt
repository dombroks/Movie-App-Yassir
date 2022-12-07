package com.younes_belouche.movieappyassir.ui.movies_list

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import androidx.navigation.fragment.findNavController
import com.younes_belouche.domain.entities.Movie
import com.younes_belouche.movieappyassir.R
import com.younes_belouche.movieappyassir.databinding.FragmentMoviesListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesList : Fragment(), MovieAdapter.OnItemClickListener {
    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MoviesListViewModel by viewModels()
    private var moviesAdapter: MovieAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMoviesList()
        viewModel.moviesList.observe(
            viewLifecycleOwner
        ) {
            moviesAdapter = MovieAdapter(
                it.data!!, this
            )
            binding.let {
                it.recyclerView.apply {
                    this.adapter = moviesAdapter
                    this.setHasFixedSize(true)
                }
            }

        }
    }

    override fun onItemClick(movieId: Long) {
        val bundle = bundleOf("movieId" to movieId)
        findNavController().navigate(R.id.action_moviesList_to_movieDetails, bundle)
    }


}