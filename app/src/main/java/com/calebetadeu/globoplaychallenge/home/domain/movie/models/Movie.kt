package com.calebetadeu.globoplaychallenge.home.domain.movie.models

data class Movie(
    val id: Int? = 0,
    val title: String,
    val posterUrl: String,
    val overview: String,
    val releaseDate: String,
    val averageRating: Double?,
    val voteCount: Int?
)