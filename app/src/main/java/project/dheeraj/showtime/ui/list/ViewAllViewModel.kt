package project.dheeraj.showtime.ui.list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import project.dheeraj.showtime.data.local.dao.BookmarkDao
import project.dheeraj.showtime.data.model.MovieDB
import project.dheeraj.showtime.data.repository.NetworkRepository

@ExperimentalCoroutinesApi
class ViewAllViewModel @ViewModelInject constructor(
    private val databaseDao : BookmarkDao,
    private val repository : NetworkRepository
) : ViewModel() {

    private val _bookmarks = MutableLiveData<List<MovieDB>>()

    var bookmarks : MutableLiveData<List<MovieDB>> = _bookmarks

    fun fetchPopular() =
        repository.getPopularMovieResult().cachedIn(viewModelScope)

    fun fetchUpcoming() =
        repository.getUpcomingMovieResult().cachedIn(viewModelScope)

    fun fetchTopRated() =
        repository.getTopRatedMovieResult().cachedIn(viewModelScope)

    fun fetchBookmarks() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = databaseDao.getAllBookmark()
            bookmarks.postValue(data)
        }
    }

}