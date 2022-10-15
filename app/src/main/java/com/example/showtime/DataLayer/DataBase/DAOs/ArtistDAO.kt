package com.example.showtime.DataLayer.DataBase.DAOs

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.showtime.DataLayer.DataClasses.DataLayerPeople.Artists

interface ArtistDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertArtist(artist:List<Artists>)

    @Query("DELETE FROM popular_artists")
    suspend fun DeleteAllArtist()

    @Query("SELECT * FROM popular_artists")
    suspend fun GetAllArtist():List<Artists>

}