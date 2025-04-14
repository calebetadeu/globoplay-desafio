package com.calebetadeu.globoplaychallenge.home.domain.movie.repository

import com.calebetadeu.globoplaychallenge.core.domain.util.NetworkError
import com.calebetadeu.globoplaychallenge.core.domain.util.Result
import com.calebetadeu.globoplaychallenge.home.domain.movie.models.Movie


interface MovieRepository {
    suspend fun getPopularMovies(): Result<List<Movie>, NetworkError>
}