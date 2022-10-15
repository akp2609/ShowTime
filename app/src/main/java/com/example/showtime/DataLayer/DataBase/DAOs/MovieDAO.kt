package com.example.showtime.DataLayer.DataBase.DAOs

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.showtime.DataLayer.DataClasses.DataLayerMovie.Movies

interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertMovie(movie:List<Movies>)

    @Query("DELETE FROM POPULAR_MOVIES")
    suspend fun DeleteAllMovies()

    @Query("SELECT * FROM popular_movies")
    suspend fun GetAllMovies():List<Movies>

}