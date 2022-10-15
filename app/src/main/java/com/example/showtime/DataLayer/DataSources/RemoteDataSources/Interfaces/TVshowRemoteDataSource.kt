package com.example.showtime.DataLayer.DataSources.RemoteDataSources.Interfaces

import com.example.showtime.DataLayer.DataClasses.DataLayerTV.TVList
import retrofit2.Response

interface TVshowRemoteDataSource {

    suspend fun getTVshows():Response<TVList>
}