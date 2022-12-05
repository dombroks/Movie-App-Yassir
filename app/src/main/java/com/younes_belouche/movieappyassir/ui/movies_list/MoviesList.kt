package com.younes_belouche.movieappyassir.ui.movies_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.younes_belouche.movieappyassir.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesList : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    companion object {
      @JvmStatic
        fun newInstance() =
            MoviesList()
    }
}