package com.example.showtime.DataLayer.DataSources.LocalDataSources.Interfaces

import com.example.showtime.DataLayer.DataClasses.DataLayerTV.TVshow

interface TVshowLocalDataSource {
    suspend fun getTVshows():List<TVshow>
    suspend fun saveTVshows(TVshows:List<TVshow>)
    suspend fun clearAll()
}