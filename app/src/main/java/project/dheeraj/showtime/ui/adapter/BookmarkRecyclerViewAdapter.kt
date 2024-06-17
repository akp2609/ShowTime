package project.dheeraj.showtime.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.ExperimentalCoroutinesApi
import project.dheeraj.showtime.R
import project.dheeraj.showtime.data.model.Movie
import project.dheeraj.showtime.data.model.MovieDB
import project.dheeraj.showtime.databinding.ItemSearchBinding
import project.dheeraj.showtime.utils.CONSTANTS

/**
 * Created by Dheeraj Kotwani on 22-03-2021.
 */

@ExperimentalCoroutinesApi
class BookmarkRecyclerViewAdapter(
        val movies : List<MovieDB>
) : RecyclerView.Adapter<BookmarkRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemSearchBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder) {

            Glide.with(itemView)
                .load("${CONSTANTS.ImageBaseURL}${movies[position].poster_path}")
                .placeholder(CONSTANTS.moviePlaceHolder[position%4])
                .error(CONSTANTS.moviePlaceHolder[position%4])
                .into(binding.searchImage)

            binding.root.setOnClickListener {
                val movie = Movie(
                    id = movies[position].id,
                    title =  movies[position].title,
                    backdrop_path = movies[position].backdrop_path,
                    poster_path = movies[position].poster_path,
                    overview = movies[position].overview
                )
                val bundle = bundleOf(CONSTANTS.movie to movie)
                it.findNavController().navigate(R.id.action_viewAllFragment_to_movieDetailsFragment, bundle)
            }

        }

    }

    override fun getItemCount() = movies.size


}