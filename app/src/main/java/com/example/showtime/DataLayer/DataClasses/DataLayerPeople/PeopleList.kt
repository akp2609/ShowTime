package com.example.showtime.DataLayer.DataClasses.DataLayerPeople


import com.google.gson.annotations.SerializedName

data class PeopleList(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val celebrities: List<Artists>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)