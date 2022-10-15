package com.example.showtime.Domain.UseCases.UpdateUseCase

import com.example.showtime.DataLayer.DataClasses.DataLayerTV.TVshow
import com.example.showtime.Domain.RepositoriesInterfaces.TVshowRepository

class UpdateTVshowUsecase(private val tVshowRepository: TVshowRepository) {

    suspend fun execute():List<TVshow>? = tVshowRepository.updateTVshows()
}