package com.example.showtime.DataLayer.DataSources.CacheDataSource.Implementation

import com.example.showtime.DataLayer.DataClasses.DataLayerMovie.Movies
import com.example.showtime.DataLayer.DataClasses.DataLayerPeople.Artists
import com.example.showtime.DataLayer.DataSources.CacheDataSource.Interfaces.ArtistsCacheDataSource

class ArtistsCacheDataSourceImp:ArtistsCacheDataSource {

    private var artistslist = ArrayList<Artists>()

    override suspend fun getArtistsFromCache(): List<Artists> = artistslist

    override suspend fun saveArtistsToCache(artists: List<Artists>) {
        artistslist.clear()
        artistslist = ArrayList(artists)
    }
}