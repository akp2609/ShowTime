package com.example.showtime.DataLayer.DataSources.LocalDataSources.Implementation

import com.example.showtime.DataLayer.DataBase.DAOs.ArtistDAO
import com.example.showtime.DataLayer.DataClasses.DataLayerPeople.Artists
import com.example.showtime.DataLayer.DataSources.LocalDataSources.Interfaces.ArtistsLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistsLocalDataSourceImp(private val artistsdao:ArtistDAO):ArtistsLocalDataSource {

    override suspend fun getArtists(): List<Artists> = artistsdao.GetAllArtist()

    override suspend fun saveArtists(artists: List<Artists>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistsdao.InsertArtist(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistsdao.DeleteAllArtist()
        }
    }
}