package com.example.showtime.DataLayer.DataSources.RemoteDataSources.Interfaces

import com.example.showtime.DataLayer.DataClasses.DataLayerPeople.PeopleList
import retrofit2.Response

interface ArtistsRemoteDataSource {

    suspend fun getArtists():Response<PeopleList>
}