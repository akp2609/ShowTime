package com.example.showtime.DataLayer.DataSources.LocalDataSources.Implementation

import com.example.showtime.DataLayer.DataBase.DAOs.TVshowDAO
import com.example.showtime.DataLayer.DataClasses.DataLayerTV.TVshow
import com.example.showtime.DataLayer.DataSources.LocalDataSources.Interfaces.TVshowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVshowLocalDataSourceImp(private val tVshowDAO: TVshowDAO):TVshowLocalDataSource {

    override suspend fun getTVshows(): List<TVshow> = tVshowDAO.GetAllTVshows()

    override suspend fun saveTVshows(TVshows: List<TVshow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tVshowDAO.InsertTVshow(TVshows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch{
            tVshowDAO.DeleteAllTVshows()
        }
    }
}