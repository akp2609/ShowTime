package project.dheeraj.showtime.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import project.dheeraj.showtime.utils.CONSTANTS

/**
 * Created by Dheeraj Kotwani on 14-04-2021.
 */
@Entity(tableName = CONSTANTS.TABLE_NAME)
data class MovieDB (
    @PrimaryKey
    val id: Int,
    val poster_path: String,
    val overview: String,
    val title: String,
    val backdrop_path: String
)