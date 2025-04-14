package com.calebetadeu.globoplaychallenge.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.calebetadeu.globoplaychallenge.core.domain.util.onError
import com.calebetadeu.globoplaychallenge.core.domain.util.onSuccess
import com.calebetadeu.globoplaychallenge.home.domain.movie.useCase.GetPopularMoviesUseCase
import com.calebetadeu.globoplaychallenge.home.presentation.models.toMovieUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state
        .onStart { loadPopularMovies() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            HomeState()
        )

    private fun loadPopularMovies() {

        viewModelScope.launch {
            _state.update {
                it.copy(
                    moviesState = it.moviesState.copy(
                        isLoading = true
                    )
                )
            }

            getPopularMoviesUseCase.invoke()
                .onSuccess { movies ->
                    _state.update {
                        it.copy(
                            moviesState = it.moviesState.copy(
                                isLoading = false,
                                popularMovies = movies.map { movie -> movie.toMovieUi() }
                            )
                        )
                    }

                }
                .onError { error ->
                    _state.update {
                        it.copy(
                            moviesState = it.moviesState.copy(
                                isLoading = false,
                                error = error.toString()
                            )
                        )

                    }

                }
        }
    }
}