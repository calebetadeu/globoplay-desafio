package com.calebetadeu.globoplaychallenge.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.calebetadeu.globoplaychallenge.core.presentation.components.BottomBarGloboPlay
import com.calebetadeu.globoplaychallenge.core.presentation.components.GloboPlayTopBar
import com.calebetadeu.globoplaychallenge.home.presentation.HomeRoot

@Composable
fun NavigationApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        topBar = {
            GloboPlayTopBar()
        },
        bottomBar = {
            BottomBarGloboPlay(
                navController = navController
            )
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = Home, modifier = modifier.padding(innerPadding)) {
            composable<Home> {
                HomeRoot(modifier)
            }
            composable<MyList> {
                Column(
                    modifier = Modifier.fillMaxSize().padding(innerPadding),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Text("Favoritos", fontSize = 28.sp)

                }
            }
        }

    }
}