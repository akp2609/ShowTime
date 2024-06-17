package project.dheeraj.showtime.ui.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import kotlinx.coroutines.Dispatchers
import project.dheeraj.showtime.data.model.Resource
import project.dheeraj.showtime.data.repository.NetworkRepository
import java.net.SocketTimeoutException

class SearchViewModel @ViewModelInject constructor(
    private val networkRepository: NetworkRepository
) : ViewModel() {

    fun searchMovie(query: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        try {
            val apiResponse =
                networkRepository.getSearchResult(query).cachedIn(viewModelScope)
            emit(Resource.success(apiResponse))
        }
        catch (e: Exception) {
            if (e is SocketTimeoutException)
                emit(Resource.error("Something went wrong!"))
        }
    }

    fun getSearchMovie(query: String) =
        networkRepository.getSearchResult(query).cachedIn(viewModelScope)



}