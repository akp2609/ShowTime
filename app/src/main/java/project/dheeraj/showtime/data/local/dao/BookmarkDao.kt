package project.dheeraj.showtime.data.local.dao

import androidx.room.*
import project.dheeraj.showtime.data.model.Movie
import project.dheeraj.showtime.data.model.MovieDB
import project.dheeraj.showtime.utils.CONSTANTS.Companion.TABLE_NAME

/**
 * Created by Dheeraj Kotwani on 11-04-2021.
 */

/**
 * Data Access Object[DAO]
 */
@Dao
interface BookmarkDao {

    /**
     * Insert [Movie] into the Movie Table
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(Movie: MovieDB)

    /**
     * Delete movie from Database
     */
    @Delete
    suspend fun removeMovie(movie: MovieDB)

    /**
     * Delete [Movie] by [Movie.id]
     */
    @Query("Delete from ${TABLE_NAME} where id=:id")
    suspend fun deleteMovieById(id : Int)

    /**
     * Fetch all movies
     */
    @Query("Select * from $TABLE_NAME")
    fun getAllBookmark() : List<MovieDB>

    /**
     * Check movie exist in DB
     */
    @Query("SELECT EXISTS (SELECT 1 FROM $TABLE_NAME WHERE id = :id)")
    fun bookmarkExist(id: Int): Boolean


}