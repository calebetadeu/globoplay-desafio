package com.calebetadeu.globoplaychallenge.home.data.mappers

import com.calebetadeu.globoplaychallenge.home.data.dto.MovieDto
import com.calebetadeu.globoplaychallenge.home.domain.models.Movie


fun MovieDto.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        posterUrl = posterPath?.let { "https://image.tmdb.org/t/p/w500$it" } ?: "",
        overview = overview,
        releaseDate = releaseDate,
        averageRating = voteAverage,
        voteCount = voteCount
    )
}