package com.calebetadeu.globoplaychallenge.home.presentation

import com.calebetadeu.globoplaychallenge.home.presentation.models.MovieUi

data class MoviesState(
    val isLoading: Boolean = false,
    val popularMovies: List<MovieUi> = emptyList(),
    val error: String? = null
)