package project.dheeraj.showtime.data.model

/** ShowTime by Aman Kumar Pandey */

/**
 * State Management for UI and Data
 */
sealed class State<Any> {

    class Loading<Any> : State<Any>()

    data class Success<Any>(val data: Any) : State<Any>()

    data class Error<Any>(val message : String) : State<Any>()

    companion object {
        /**
         * Returns [State.Loading] instance
         */
        fun <Any> loading() = Loading<Any>()

        /**
         * Returns [State.Success] instance
         * @param data Data to emit with Status
         */
        fun <Any> success(data: Any) = Success<Any>(data)

        /**
         * Returns [State.Error] instance.
         * @param message description of failure.
         */
        fun <Any> error(message: String) = Error<Any>(message)
    }
}