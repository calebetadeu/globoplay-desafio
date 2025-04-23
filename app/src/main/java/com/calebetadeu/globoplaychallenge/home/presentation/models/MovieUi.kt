package com.calebetadeu.globoplaychallenge.home.presentation.models

import com.calebetadeu.globoplaychallenge.home.domain.models.Movie
import java.text.NumberFormat
import java.util.Locale

data class MovieUi(
    val id: Int? = 0 ,
    val title: String,
    val posterUrl: String,
    val overview: String,
    val releaseDate: String,
    val averageRating: DisplayableNumber?, // Ex.: 7.5 convertido para um DisplayableNumber
    val voteCount: Int?,     // Ex.: 1200 convertido para um DisplayableNumber
)
fun Movie.toMovieUi(): MovieUi {
    return MovieUi(
        id = id,
        title = title,
        posterUrl = posterUrl,
        overview = overview,
        releaseDate = releaseDate,
        averageRating = averageRating?.toDisplayableNumber(),
        voteCount = voteCount,
    )
}
private fun Double.toDisplayableNumber(): DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
    return DisplayableNumber(
        value = this,
        formatted = formatter.format(this)
    )
}

data class DisplayableNumber(
    val value: Double,
    val formatted: String
)