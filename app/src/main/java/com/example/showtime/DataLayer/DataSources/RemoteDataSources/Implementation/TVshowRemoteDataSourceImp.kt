package com.example.showtime.DataLayer.DataSources.RemoteDataSources.Implementation

import com.example.showtime.DataLayer.API.TMBDsevice
import com.example.showtime.DataLayer.DataClasses.DataLayerTV.TVList
import com.example.showtime.DataLayer.DataSources.RemoteDataSources.Interfaces.TVshowRemoteDataSource
import retrofit2.Response

class TVshowRemoteDataSourceImp(private val tmbdservice:TMBDsevice,private val apikey:String):TVshowRemoteDataSource {
    override suspend fun getTVshows(): Response<TVList> = tmbdservice.getTVshows(apikey)
}