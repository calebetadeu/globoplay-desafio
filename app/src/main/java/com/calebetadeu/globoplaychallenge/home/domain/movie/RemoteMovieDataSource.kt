package com.calebetadeu.globoplaychallenge.home.domain.movie

import com.calebetadeu.globoplaychallenge.core.domain.util.NetworkError
import com.calebetadeu.globoplaychallenge.home.data.movie.dto.MovieResponseDto
import com.calebetadeu.globoplaychallenge.core.domain.util.Result
interface RemoteMovieDataSource {
    suspend fun getPopularMovies(apiKey: String, page: Int = 1): Result<MovieResponseDto, NetworkError>
}