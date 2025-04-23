package com.calebetadeu.globoplaychallenge.home.di

import com.calebetadeu.globoplaychallenge.BuildConfig
import com.calebetadeu.globoplaychallenge.core.data.networking.HttpClientFactory
import com.calebetadeu.globoplaychallenge.home.data.movie.MovieRepositoryImpl
import com.calebetadeu.globoplaychallenge.home.data.movie.network.KtorRemoteMovieDataSourceImpl
import com.calebetadeu.globoplaychallenge.home.domain.movie.RemoteMovieDataSource
import com.calebetadeu.globoplaychallenge.home.domain.movie.repository.MovieRepository
import com.calebetadeu.globoplaychallenge.home.domain.movie.useCase.GetPopularMoviesUseCase
import com.calebetadeu.globoplaychallenge.home.presentation.HomeViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homeModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    single<RemoteMovieDataSource>{
        KtorRemoteMovieDataSourceImpl(
            httpClient = get()
        )
    }
    factory { GetPopularMoviesUseCase(movieRepository = get()) }
    single<MovieRepository> {
        MovieRepositoryImpl(
            remoteMovieDataSource = get(),
            apiKey =  BuildConfig.API_KEY
        )
    }
    viewModelOf(::HomeViewModel)
}
