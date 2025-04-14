package com.calebetadeu.globoplaychallenge.home.data.movie

import com.calebetadeu.globoplaychallenge.core.domain.util.NetworkError
import com.calebetadeu.globoplaychallenge.home.domain.movie.RemoteMovieDataSource
import com.calebetadeu.globoplaychallenge.home.domain.movie.models.Movie
import com.calebetadeu.globoplaychallenge.home.domain.movie.repository.MovieRepository
import com.calebetadeu.globoplaychallenge.core.domain.util.Result
import com.calebetadeu.globoplaychallenge.core.domain.util.map
import com.calebetadeu.globoplaychallenge.home.data.movie.mappers.toMovie

class MovieRepositoryImpl(
    private val remoteMovieDataSource: RemoteMovieDataSource,
    private val apiKey: String
) : MovieRepository {

    override suspend fun getPopularMovies(): Result<List<Movie>, NetworkError> {
        return remoteMovieDataSource.getPopularMovies(apiKey, page = 1)
            .map { dto ->
                dto.results.map { it.toMovie() }
            }
    }
}