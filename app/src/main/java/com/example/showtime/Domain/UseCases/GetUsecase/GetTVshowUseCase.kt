package com.example.showtime.Domain.UseCases.GetUsecase

import com.example.showtime.DataLayer.DataClasses.DataLayerTV.TVshow
import com.example.showtime.Domain.RepositoriesInterfaces.TVshowRepository

class GetTVshowUseCase(private val tVshowRepository: TVshowRepository) {

    suspend fun execute():List<TVshow>? = tVshowRepository.getTVshows()
}