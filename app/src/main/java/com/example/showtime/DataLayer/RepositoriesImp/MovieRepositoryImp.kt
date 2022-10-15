package com.example.showtime.DataLayer.RepositoriesImp

import android.util.Log
import com.example.showtime.DataLayer.DataClasses.DataLayerMovie.MovieList
import com.example.showtime.DataLayer.DataClasses.DataLayerMovie.Movies
import com.example.showtime.DataLayer.DataSources.CacheDataSource.Interfaces.MovieCacheDataSource
import com.example.showtime.DataLayer.DataSources.LocalDataSources.Interfaces.MovieLocalDataSource
import com.example.showtime.DataLayer.DataSources.RemoteDataSources.Interfaces.MovieRemoteDataSource
import com.example.showtime.Domain.RepositoriesInterfaces.MovieRepository
import kotlin.math.log

class MovieRepositoryImp(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {


    override suspend fun getMovies(): List<Movies>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movies>? {
        val newmovielist = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovies(newmovielist)
        movieCacheDataSource.saveMoviesToCache(newmovielist)
        return newmovielist
    }

    suspend fun getMoviesFromAPI(): List<Movies> {
        lateinit var movieList: List<Movies>

        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body != null){
                movieList = body.movies!!
            }
        } catch (e: Exception) {
            Log.i("My tag", e.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromDB():List<Movies>{
        lateinit var movieList:List<Movies>

        try {
            val movieList = movieLocalDataSource.getMovies()
        }catch (e:Exception){
            Log.i("My Tag",e.message.toString())
        }

        if(movieList.size>0){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMovies(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromCache():List<Movies>{
        lateinit var movieList:List<Movies>

        try {
            val movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (e:Exception){
            Log.i("My Tag",e.message.toString())
        }

        if(movieList.size>0){
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}