package com.example.showtime.DataLayer.DataSources.CacheDataSource.Interfaces

import com.example.showtime.DataLayer.DataClasses.DataLayerPeople.Artists

interface ArtistsCacheDataSource {
    suspend fun getArtistsFromCache():List<Artists>
    suspend fun saveArtistsToCache(artists:List<Artists>)
}