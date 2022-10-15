package com.example.showtime.DataLayer.DataSources.CacheDataSource.Implementation

import com.example.showtime.DataLayer.DataClasses.DataLayerTV.TVshow
import com.example.showtime.DataLayer.DataSources.CacheDataSource.Interfaces.TVshowCacheDataSource

class TVshowCacheDataSourceImp:TVshowCacheDataSource {

    private var tvshowlist = ArrayList<TVshow>()

    override suspend fun getTVshowFromCache(): List<TVshow> = tvshowlist

    override suspend fun saveTVshowToCache(tvshow: List<TVshow>) {
        tvshowlist.clear()
        tvshowlist = ArrayList(tvshow)
    }
}