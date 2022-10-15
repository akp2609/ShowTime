package com.example.showtime.Domain.UseCases.UpdateUseCase

import com.example.showtime.DataLayer.DataClasses.DataLayerMovie.Movies
import com.example.showtime.Domain.RepositoriesInterfaces.MovieRepository

class UpdateMovieUsecase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movies>? = movieRepository.updateMovies()
}