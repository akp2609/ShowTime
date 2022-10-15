package com.example.showtime.DataLayer.RepositoriesImp

import android.util.Log
import com.example.showtime.DataLayer.DataClasses.DataLayerTV.TVshow
import com.example.showtime.DataLayer.DataSources.CacheDataSource.Interfaces.TVshowCacheDataSource
import com.example.showtime.DataLayer.DataSources.LocalDataSources.Interfaces.TVshowLocalDataSource
import com.example.showtime.DataLayer.DataSources.RemoteDataSources.Interfaces.TVshowRemoteDataSource
import com.example.showtime.Domain.RepositoriesInterfaces.TVshowRepository

class TVshowRepositoryImp(
    private val tvshowRemoteDataSource:TVshowRemoteDataSource,
    private val tVshowLocalDataSource: TVshowLocalDataSource,
    private val tVshowCacheDataSource: TVshowCacheDataSource
):TVshowRepository {
    override suspend fun getTVshows(): List<TVshow>? {
        return getTVshowsFromCache()
    }

    override suspend fun updateTVshows(): List<TVshow>? {
        val newtvshowlist = getTVshowsFromAPI()
        tVshowLocalDataSource.clearAll()
        tVshowLocalDataSource.saveTVshows(newtvshowlist)
        tVshowCacheDataSource.saveTVshowToCache(newtvshowlist)
        return newtvshowlist
    }

    suspend fun getTVshowsFromAPI():List<TVshow>{
        lateinit var tvshowlist:List<TVshow>

        try {

            val response = tvshowRemoteDataSource.getTVshows()
            val body = response.body()
            if(body!=null){
                tvshowlist = body.TVshows!!
            }

        }catch (e:Exception){
            Log.i("My Tag",e.message.toString())
        }

        return tvshowlist
    }

    suspend fun getTVshowsFromDB():List<TVshow>{
        lateinit var tvshowList:List<TVshow>

        try {
            tvshowList = tVshowLocalDataSource.getTVshows()
        }catch (e:Exception){
            Log.i("My Tag",e.message.toString())
        }

        if(tvshowList.size>0){
            return tvshowList
        }else{
            tvshowList = getTVshowsFromAPI()
            tVshowLocalDataSource.saveTVshows(tvshowList)
        }

        return tvshowList
    }

    suspend fun getTVshowsFromCache():List<TVshow>{
        lateinit var tvshowList:List<TVshow>

        try {
            tvshowList = tVshowCacheDataSource.getTVshowFromCache()
        }catch (e:Exception){
            Log.i("My Tag",e.message.toString())
        }

        if(tvshowList.size>0){
            return tvshowList
        }else{
            tvshowList = getTVshowsFromDB()
            tVshowCacheDataSource.saveTVshowToCache(tvshowList)
        }

        return tvshowList
    }
}