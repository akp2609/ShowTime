package com.example.showtime.DataLayer.DataSources.RemoteDataSources.Interfaces

import com.example.showtime.DataLayer.DataClasses.DataLayerMovie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies():Response<MovieList>

}