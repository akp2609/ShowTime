package com.example.showtime.DataLayer.DataClasses.DataLayerTV


import com.google.gson.annotations.SerializedName

data class TVList(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val TVshows: List<TVshow>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)