package com.calebetadeu.globoplaychallenge.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.calebetadeu.globoplaychallenge.ui.theme.GloboPlayChallengeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeRoot(
    modifier: Modifier,
    viewModel: HomeViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        modifier = modifier,
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier,
    state: HomeState,
    onAction: (HomeAction) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text("Home")
    }


}

@Preview
@Composable
private fun Preview() {
    GloboPlayChallengeTheme{
       HomeScreen(
           state = HomeState(),
           onAction = {},
           modifier = Modifier
       )
   }
}