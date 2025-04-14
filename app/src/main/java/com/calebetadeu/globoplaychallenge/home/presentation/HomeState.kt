package com.calebetadeu.globoplaychallenge.home.presentation

import com.calebetadeu.globoplaychallenge.home.presentation.movie.MoviesState

data class HomeState(
    val moviesState: MoviesState = MoviesState(),
)
