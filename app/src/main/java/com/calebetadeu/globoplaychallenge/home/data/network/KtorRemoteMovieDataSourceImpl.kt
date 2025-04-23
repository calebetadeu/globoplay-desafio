package com.calebetadeu.globoplaychallenge.home.data.network

import com.calebetadeu.globoplaychallenge.core.data.networking.constructUrl
import com.calebetadeu.globoplaychallenge.core.data.networking.safeCall
import com.calebetadeu.globoplaychallenge.core.domain.util.NetworkError
import com.calebetadeu.globoplaychallenge.core.domain.util.Result
import com.calebetadeu.globoplaychallenge.home.data.dto.MovieResponseDto
import com.calebetadeu.globoplaychallenge.home.domain.dataSource.RemoteMovieDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class KtorRemoteMovieDataSourceImpl(
    private val httpClient: HttpClient,
): RemoteMovieDataSource {

    override suspend fun getPopularMovies(apiKey: String, page: Int): Result<MovieResponseDto, NetworkError> {
        return safeCall<MovieResponseDto> {
            // Usa constructUrl para montar a URL completa a partir do path "/movie/popular"
            httpClient.get(constructUrl("/movie/popular")) {
                parameter("api_key", apiKey)
                parameter("language", "pt-BR")
                parameter("page", page)
            }
        }
    }
}