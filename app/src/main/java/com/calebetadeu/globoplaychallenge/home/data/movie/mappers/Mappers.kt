package com.calebetadeu.globoplaychallenge.home.data.movie.mappers

import com.calebetadeu.globoplaychallenge.home.data.movie.dto.MovieDto
import com.calebetadeu.globoplaychallenge.home.domain.movie.models.Movie


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