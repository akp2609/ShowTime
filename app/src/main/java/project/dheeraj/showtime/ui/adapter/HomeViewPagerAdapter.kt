package project.dheeraj.showtime.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import project.dheeraj.showtime.data.model.Movie
import project.dheeraj.showtime.ui.main.viewpager.HomeViewPagerFragment

/**
 * Created by Dheeraj Kotwani on 05-04-2021.
 */

@ExperimentalCoroutinesApi
class HomeViewPagerAdapter (
    fm : FragmentManager,
    lifecycle: Lifecycle,
    val movies : List<Movie> = ArrayList()
): FragmentStateAdapter(fm, lifecycle){

    override fun getItemCount(): Int = movies.size

    override fun createFragment(position: Int): Fragment {
        return HomeViewPagerFragment(movies[position])
    }

}