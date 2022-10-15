package com.example.showtime.DataLayer.DataBase.DAOs.ROOMDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.showtime.DataLayer.DataBase.DAOs.ArtistDAO
import com.example.showtime.DataLayer.DataBase.DAOs.MovieDAO
import com.example.showtime.DataLayer.DataBase.DAOs.TVshowDAO
import com.example.showtime.DataLayer.DataClasses.DataLayerMovie.Movies
import com.example.showtime.DataLayer.DataClasses.DataLayerPeople.Artists
import com.example.showtime.DataLayer.DataClasses.DataLayerTV.TVshow

@Database(entities = [Movies::class,TVshow::class,Artists::class], version = 1, exportSchema = false)
abstract class TMBDDatabase : RoomDatabase(){

    abstract fun moviedao():MovieDAO
    abstract fun tvshowdao():TVshowDAO
    abstract fun artistdao():ArtistDAO

}