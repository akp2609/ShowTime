package com.example.showtime.DataLayer.DataSources.LocalDataSources.Implementation

import androidx.compose.runtime.DisposableEffect
import com.example.showtime.DataLayer.DataBase.DAOs.MovieDAO
import com.example.showtime.DataLayer.DataClasses.DataLayerMovie.Movies
import com.example.showtime.DataLayer.DataSources.LocalDataSources.Interfaces.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImp(private val movieDAO: MovieDAO):MovieLocalDataSource {

    override suspend fun getMovies(): List<Movies> = movieDAO.GetAllMovies()

    override suspend fun saveMovies(movies: List<Movies>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.InsertMovie(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.DeleteAllMovies()
        }
    }
}