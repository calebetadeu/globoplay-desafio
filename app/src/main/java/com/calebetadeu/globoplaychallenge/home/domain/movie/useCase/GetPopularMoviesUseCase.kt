package com.calebetadeu.globoplaychallenge.home.domain.movie.useCase

import com.calebetadeu.globoplaychallenge.core.domain.util.NetworkError
import com.calebetadeu.globoplaychallenge.core.domain.util.Result
import com.calebetadeu.globoplaychallenge.home.domain.movie.models.Movie
import com.calebetadeu.globoplaychallenge.home.domain.movie.repository.MovieRepository

class GetPopularMoviesUseCase(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(): Result<List<Movie>, NetworkError> {
        return movieRepository.getPopularMovies()
    }
}

