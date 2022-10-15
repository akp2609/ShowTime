package com.example.showtime.DataLayer.DataBase.DAOs

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.showtime.DataLayer.DataClasses.DataLayerTV.TVshow

interface TVshowDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertTVshow(tvshows:List<TVshow>)

    @Query("DELETE FROM popular_tvshows")
    suspend fun DeleteAllTVshows()

    @Query("SELECT * FROM popular_tvshows")
    suspend fun GetAllTVshows():List<TVshow>
}