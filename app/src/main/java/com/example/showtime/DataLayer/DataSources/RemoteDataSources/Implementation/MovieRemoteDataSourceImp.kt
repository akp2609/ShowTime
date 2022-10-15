package com.example.showtime.DataLayer.DataSources.RemoteDataSources.Implementation

import com.example.showtime.DataLayer.API.TMBDsevice
import com.example.showtime.DataLayer.DataClasses.DataLayerMovie.MovieList
import com.example.showtime.DataLayer.DataSources.RemoteDataSources.Interfaces.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImp(private val tmbdservice:TMBDsevice,private val apikey:String):MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmbdservice.getMovies(apikey)

}