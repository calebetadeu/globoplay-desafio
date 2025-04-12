package com.calebetadeu.globoplaychallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.navArgs
import com.calebetadeu.globoplaychallenge.core.presentation.components.BottomBarGloboPlay
import com.calebetadeu.globoplaychallenge.core.presentation.components.GloboPlayTopBar
import com.calebetadeu.globoplaychallenge.home.presentation.HomeRoot
import com.calebetadeu.globoplaychallenge.navigation.NavigationApp
import com.calebetadeu.globoplaychallenge.ui.theme.GloboPlayChallengeTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)
        setContent {
            GloboPlayChallengeTheme {
                NavigationApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {

}
