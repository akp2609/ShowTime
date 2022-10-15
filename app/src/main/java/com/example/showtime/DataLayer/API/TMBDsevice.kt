package com.example.showtime.DataLayer.API


import com.example.showtime.DataLayer.DataClasses.DataLayerMovie.MovieList
import com.example.showtime.DataLayer.DataClasses.DataLayerPeople.PeopleList
import com.example.showtime.DataLayer.DataClasses.DataLayerTV.TVList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMBDsevice {

    @GET("movie/popular")
    suspend fun getMovies(@Query("api_key") apikey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getTVshows(@Query("api_key")apikey:String): Response<TVList>

    @GET("person/popular")
    suspend fun getPeople(@Query("api_key")apikey:String): Response<PeopleList>
}