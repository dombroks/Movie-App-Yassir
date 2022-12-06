package com.younes_belouche.movieappyassir.ui.movies_list

import com.bumptech.glide.Glide
import com.younes_belouche.domain.entities.Movie;
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.younes_belouche.movieappyassir.R
import com.younes_belouche.movieappyassir.databinding.MovieItemBinding


class MovieAdapter(
    private var items: List<Movie>,
    private val listener: OnItemClickListener,
) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(view);
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder) {
            with(items[position]) {
                Glide.with(binding.image.context)
                    .load(this.poster_path)
                    .into(binding.image)
            }
        }


/*
        holder.cardView.setOnClickListener {
            listener.onItemClick(position)
        }

 */
    }

    inner class ViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        // val cardView: CardView = itemView.findViewById(R.id.itemLayout)

    }

    fun filter(filteredList: List<Movie>) {
        items = filteredList
        //notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }


}