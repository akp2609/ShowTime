package com.example.showtime.DataLayer.DataSources.LocalDataSources.Interfaces

import com.example.showtime.DataLayer.DataClasses.DataLayerMovie.Movies

interface MovieLocalDataSource {
    suspend fun getMovies():List<Movies>
    suspend fun saveMovies(movies:List<Movies>)
    suspend fun clearAll()
}