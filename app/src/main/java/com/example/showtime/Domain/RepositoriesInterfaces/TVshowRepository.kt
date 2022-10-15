package com.example.showtime.Domain.RepositoriesInterfaces

import com.example.showtime.DataLayer.DataClasses.DataLayerTV.TVshow

interface TVshowRepository {

    suspend fun getTVshows():List<TVshow>?

    suspend fun updateTVshows():List<TVshow>?
}