package com.example.showtime.Domain.UseCases.GetUsecase

import com.example.showtime.DataLayer.DataClasses.DataLayerPeople.Artists
import com.example.showtime.Domain.RepositoriesInterfaces.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute():List<Artists>? = artistRepository.getArtists()
}