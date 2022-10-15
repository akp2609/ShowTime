package com.example.showtime.Domain.UseCases.UpdateUseCase

import com.example.showtime.DataLayer.DataClasses.DataLayerPeople.Artists
import com.example.showtime.Domain.RepositoriesInterfaces.ArtistRepository

class UpdateArtistsUsecase(private val artistRepository: ArtistRepository) {

    suspend fun execute():List<Artists>? = artistRepository.updateArtists()
}