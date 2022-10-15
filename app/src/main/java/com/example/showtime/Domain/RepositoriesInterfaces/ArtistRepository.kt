package com.example.showtime.Domain.RepositoriesInterfaces

import com.example.showtime.DataLayer.DataClasses.DataLayerPeople.Artists

interface ArtistRepository {

    suspend fun getArtists():List<Artists>?

    suspend fun updateArtists():List<Artists>?
}