package com.example.showtime.DataLayer.DataSources.CacheDataSource.Implementation

import com.example.showtime.DataLayer.DataClasses.DataLayerMovie.Movies
import com.example.showtime.DataLayer.DataSources.CacheDataSource.Interfaces.MovieCacheDataSource

class MovieCacheDataSourceImp:MovieCacheDataSource {

    private var movielist = ArrayList<Movies>()

    override suspend fun getMoviesFromCache(): List<Movies> = movielist

    override suspend fun saveMoviesToCache(movies: List<Movies>) {
        movielist.clear()
        movielist = ArrayList(movies)
    }
}