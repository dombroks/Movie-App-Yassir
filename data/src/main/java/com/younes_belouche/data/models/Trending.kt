package com.younes_belouche.data.models


import com.google.gson.annotations.SerializedName

data class Trending(
    @SerializedName("page") var page: Int? = null,
    @SerializedName("results") var results: ArrayList<Result> = arrayListOf(),
    @SerializedName("total_pages") var totalPages: Int? = null,
    @SerializedName("total_results") var totalResults: Int? = null
)