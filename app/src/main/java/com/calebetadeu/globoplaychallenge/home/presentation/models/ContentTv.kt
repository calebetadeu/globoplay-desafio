package com.calebetadeu.globoplaychallenge.home.presentation.models

import androidx.compose.runtime.Composable

data class ContentTv(
    val title: String,
    val contents: @Composable () -> Unit
)