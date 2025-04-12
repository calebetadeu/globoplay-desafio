package com.calebetadeu.globoplaychallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.calebetadeu.globoplaychallenge.home.presentation.HomeRoot
import com.calebetadeu.globoplaychallenge.home.presentation.components.GloboPlayTopBar
import com.calebetadeu.globoplaychallenge.ui.theme.GloboPlayChallengeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        // Instala a Splash Screen
        installSplashScreen()

        // Substitui o tema da Activity para que o Compose tenha controle total da UI

        super.onCreate(savedInstanceState)
        setContent {
            GloboPlayChallengeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    topBar = {
                        GloboPlayTopBar()
                    },
                    bottomBar = {
                        BottomAppBar(
                            containerColor = MaterialTheme.colorScheme.primary
                        ) {
                            // Conteúdo do BottomAppBar
                        }
                    }
                ) { innerPadding ->
                    HomeRoot(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}