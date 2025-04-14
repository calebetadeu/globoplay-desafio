package com.calebetadeu.globoplaychallenge.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.calebetadeu.globoplaychallenge.home.presentation.components.ContentListRow
import com.calebetadeu.globoplaychallenge.home.presentation.models.ContentTv
import com.calebetadeu.globoplaychallenge.home.presentation.movie.MovieScreen
import com.calebetadeu.globoplaychallenge.ui.theme.GloboPlayChallengeTheme
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeRoot(
    modifier: Modifier,
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        modifier = modifier,
        state = state
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier,
    state: HomeState,
) {
    val scrollState = rememberScrollState()

    val listOfContent = (1..6).map {
        ContentTv(
            title = "Séries",
            contents = {
                MovieScreen(
                    modifier = modifier,
                    movieList = state.moviesState.popularMovies
                )
            }
        )
    }

    if (state.moviesState.isLoading) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }

    }else{
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
        ) {
            listOfContent.forEach {
                ContentListRow(
                    title = it.title,
                    contents = it.contents,
                    modifier = modifier
                )
            }

        }
    }



}

@Preview
@Composable
private fun Preview() {
    GloboPlayChallengeTheme {
        HomeScreen(
            state = HomeState(),
            modifier = Modifier
        )
    }
}