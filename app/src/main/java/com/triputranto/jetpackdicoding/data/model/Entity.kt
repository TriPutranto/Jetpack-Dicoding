package com.triputranto.jetpackdicoding.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Ahmad Tri Putranto on 26/01/2020.
 * */
data class Entity(
    @SerializedName("id") var id: Int?,
    @SerializedName("title") var title: String?,
    @SerializedName("name") var name: String?,
    @SerializedName("poster_path") var poster_path: String?,
    @SerializedName("backdrop_path") var backdrop_path: String?,
    @SerializedName("release_date") var release_date: String?,
    @SerializedName("first_air_date") var first_air_date: String?,
    @SerializedName("vote_average") var vote_average: Float?,
    @SerializedName("overview") var overview: String?
)