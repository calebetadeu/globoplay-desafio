package com.calebetadeu.globoplaychallenge.home.domain.dataSource

import com.calebetadeu.globoplaychallenge.core.domain.util.NetworkError
import com.calebetadeu.globoplaychallenge.core.domain.util.Result
import com.calebetadeu.globoplaychallenge.home.data.dto.MovieResponseDto

interface RemoteMovieDataSource {
    suspend fun getPopularMovies(apiKey: String, page: Int = 1): Result<MovieResponseDto, NetworkError>
}