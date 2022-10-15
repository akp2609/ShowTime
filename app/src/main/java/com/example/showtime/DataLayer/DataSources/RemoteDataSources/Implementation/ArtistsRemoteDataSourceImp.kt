package com.example.showtime.DataLayer.DataSources.RemoteDataSources.Implementation

import com.example.showtime.DataLayer.API.TMBDsevice
import com.example.showtime.DataLayer.DataClasses.DataLayerPeople.PeopleList
import com.example.showtime.DataLayer.DataSources.RemoteDataSources.Interfaces.ArtistsRemoteDataSource
import retrofit2.Response

class ArtistsRemoteDataSourceImp(private val tmbdservice:TMBDsevice,private val apikey:String)
    :ArtistsRemoteDataSource {
    override suspend fun getArtists(): Response<PeopleList> = tmbdservice.getPeople(apikey)
}