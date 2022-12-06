package com.younes_belouche.domain.entities

data class Movie (
    var poster_path : String,
    val id : Int,
    var title : String,
    var overview : String,
)