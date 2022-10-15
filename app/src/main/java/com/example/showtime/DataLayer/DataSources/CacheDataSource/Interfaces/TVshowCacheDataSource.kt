package com.example.showtime.DataLayer.DataSources.CacheDataSource.Interfaces

import com.example.showtime.DataLayer.DataClasses.DataLayerTV.TVshow

interface TVshowCacheDataSource {
    suspend fun getTVshowFromCache():List<TVshow>
    suspend fun saveTVshowToCache(tvshow:List<TVshow>)
}