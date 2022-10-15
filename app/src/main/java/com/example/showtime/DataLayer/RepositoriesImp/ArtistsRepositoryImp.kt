package com.example.showtime.DataLayer.RepositoriesImp

import android.util.Log
import com.example.showtime.DataLayer.DataClasses.DataLayerPeople.Artists
import com.example.showtime.DataLayer.DataSources.CacheDataSource.Interfaces.ArtistsCacheDataSource
import com.example.showtime.DataLayer.DataSources.LocalDataSources.Interfaces.ArtistsLocalDataSource
import com.example.showtime.DataLayer.DataSources.RemoteDataSources.Interfaces.ArtistsRemoteDataSource
import com.example.showtime.Domain.RepositoriesInterfaces.ArtistRepository

class ArtistsRepositoryImp(
    private val artistsRemoteDataSource: ArtistsRemoteDataSource,
    private val artistsLocalDataSource: ArtistsLocalDataSource,
    private val artistsCacheDataSource: ArtistsCacheDataSource
) : ArtistRepository {


    override suspend fun getArtists(): List<Artists>? {
       return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artists>? {
        val newartistslist = getArtistsFromAPI()
        artistsLocalDataSource.clearAll()
        artistsLocalDataSource.saveArtists(newartistslist)
        artistsCacheDataSource.saveArtistsToCache(newartistslist)
        return newartistslist
    }

    suspend fun getArtistsFromAPI(): List<Artists> {
        lateinit var artistslist: List<Artists>

        try {
            val response = artistsRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artistslist = body.celebrities!!
            }
        } catch (e: Exception) {
            Log.i("My Tag", e.message.toString())
        }

        return artistslist
    }

    suspend fun getArtistsFromDB(): List<Artists> {
        lateinit var artistslist: List<Artists>

        try {
            artistslist = artistsLocalDataSource.getArtists()
        } catch (e: Exception) {
            Log.i("My Tag", e.message.toString())
        }

        if (artistslist.size > 0) {
            return artistslist
        } else {
            artistslist = getArtistsFromAPI()
            artistsLocalDataSource.saveArtists(artistslist)
        }

        return artistslist
    }

    suspend fun getArtistsFromCache():List<Artists>{
        lateinit var artistslist: List<Artists>

        try {
            artistslist = artistsCacheDataSource.getArtistsFromCache()
        } catch (e: Exception) {
            Log.i("My Tag", e.message.toString())
        }

        if (artistslist.size > 0) {
            return artistslist
        } else {
            artistslist = getArtistsFromDB()
            artistsCacheDataSource.saveArtistsToCache(artistslist)
        }

        return artistslist
    }
}