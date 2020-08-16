package com.byfrunze.di.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.byfrunze.di.R
import com.byfrunze.di.data.MovieDBList
import com.byfrunze.di.utils.imageURL
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cell_list_movie.view.*
import javax.inject.Inject

class MovieListAdapter(val picasso: Picasso) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    private var movieList = ArrayList<MovieDBList>()


    fun setupMovieList(model: List<MovieDBList>) {
        movieList.clear()
        movieList.addAll(model)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cell_list_movie, parent, false)
        )


    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewTitle = itemView.text_view_title_list
        private val imageViewPoster = itemView.image_view_poster_list

        fun bind(model: MovieDBList) {
            with(model) {
                textViewTitle.text = this.title
                picasso
                    .load("$imageURL$poster_path")
                    .into(imageViewPoster)
            }
        }
    }
}