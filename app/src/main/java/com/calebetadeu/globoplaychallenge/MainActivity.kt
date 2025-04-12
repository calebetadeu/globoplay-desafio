package com.calebetadeu.globoplaychallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
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
