package com.younes_belouche.movieappyassir.ui.movies_list


import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.younes_belouche.domain.entities.Movie
import com.younes_belouche.movieappyassir.databinding.MovieItemBinding
import java.time.LocalDate
import java.util.Date


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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val item = items[position]
        with(holder) {
            this.binding.name.text = item.title
            this.binding.year.text = LocalDate.parse(item.year).year.toString()
            this.binding.item.setOnClickListener {
                listener.onItemClick(item.id.toLong())
            }
            Glide.with(this.binding.image.context)
                .load("https://image.tmdb.org/t/p/w500/" + item.poster_path)
                .into(holder.binding.image)

        }


    }

    inner class ViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {


    }


    interface OnItemClickListener {
        fun onItemClick(movieId: Long)
    }


}