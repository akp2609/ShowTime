package com.example.showtime.DataLayer.DataSources.CacheDataSource.Interfaces

import com.example.showtime.DataLayer.DataClasses.DataLayerMovie.Movies

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movies>
    suspend fun saveMoviesToCache(movies:List<Movies>)
}