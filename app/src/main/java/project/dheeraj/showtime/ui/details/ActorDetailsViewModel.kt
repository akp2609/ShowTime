package project.dheeraj.showtime.ui.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import project.dheeraj.showtime.data.model.Resource
import project.dheeraj.showtime.data.repository.NetworkRepository
import java.net.SocketTimeoutException

/**
 * Created by Dheeraj Kotwani on 28-03-2021.
 */
class ActorDetailsViewModel @ViewModelInject constructor(
    private val repository : NetworkRepository
): ViewModel() {

    fun getPerson(person_id : Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        try {
            // Fetch data from remote
            val apiResponse = repository.getPerson(person_id)
            emit(Resource.success(apiResponse))
        } catch (e: Exception) {
            if (e is SocketTimeoutException)
                emit(Resource.error("Something went wrong!"))
        }
    }

    fun getPersonMovieCredits(person_id : Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        try {
            // Fetch Data from Api
            val apiResponse = repository.getPersonMovieCredits(person_id)
            emit(Resource.success(apiResponse))
        } catch (e : Exception) {
            if (e is SocketTimeoutException) {
                emit(Resource.error("Something went wrong!"))
            }
        }

    }


}