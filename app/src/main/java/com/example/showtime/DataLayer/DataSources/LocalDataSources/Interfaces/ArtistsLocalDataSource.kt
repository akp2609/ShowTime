package com.example.showtime.DataLayer.DataSources.LocalDataSources.Interfaces

import com.example.showtime.DataLayer.DataClasses.DataLayerPeople.Artists

interface ArtistsLocalDataSource {
    suspend fun getArtists():List<Artists>
    suspend fun saveArtists(artists:List<Artists>)
    suspend fun clearAll()
}