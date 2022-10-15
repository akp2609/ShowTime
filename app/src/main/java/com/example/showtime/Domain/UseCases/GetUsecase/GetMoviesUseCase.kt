package com.example.showtime.Domain.UseCases.GetUsecase

import com.example.showtime.DataLayer.DataClasses.DataLayerMovie.Movies
import com.example.showtime.Domain.RepositoriesInterfaces.MovieRepository

class GetMoviesUseCase(private val movieRepository:MovieRepository) {

    suspend fun execute():List<Movies>? = movieRepository.getMovies()
}