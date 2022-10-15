package com.example.showtime.Domain.RepositoriesInterfaces

import com.example.showtime.DataLayer.DataClasses.DataLayerMovie.Movies

interface MovieRepository {

    suspend fun getMovies():List<Movies>?

    suspend fun updateMovies():List<Movies>?
}