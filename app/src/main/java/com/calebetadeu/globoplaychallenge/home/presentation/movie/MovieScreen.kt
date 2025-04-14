package com.calebetadeu.globoplaychallenge.home.presentation.movie

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.calebetadeu.globoplaychallenge.home.domain.movie.models.Movie
import com.calebetadeu.globoplaychallenge.home.presentation.components.ContentItem
import com.calebetadeu.globoplaychallenge.home.presentation.models.MovieUi
import com.calebetadeu.globoplaychallenge.home.presentation.models.toMovieUi


@Composable
fun MovieScreen(
    modifier: Modifier = Modifier,
    movieList: List<MovieUi>
) {
    LazyRow {
        items(movieList.size) { movie ->
            ContentItem(movie = movieList[movie], modifier = modifier, onClick = {
            })
        }
    }

}




@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MovieRootPreview(
) {
    val listMovie = (1..20).map {
        previewMovie.copy(id = it)
    }
    MovieScreen(
        movieList = listMovie
    )
}

internal val previewMovie = Movie(
    title = "Mufasa: The Lion King",
    posterUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fpt.postermywall.com%2Findex.php%2Fart%2Ftemplate%2F21a1c803fe4ff4b858de24f5c91ec57f%2Fmovie-poster-template-design&psig=AOvVaw2yXfs_L1kwrL0vek_7MStO&ust=1744594186567000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCOiCtPjt04wDFQAAAAAdAAAAABAE",
    overview = "Simba, tendo-se tornado rei das Pride Lands, está determinado a fazer com que o seu filho siga os seus passos. Ao mesmo tempo que isto acontece, vamos conhecer a história por detrás de Mufasa, entendo melhor a sua origem.",
    releaseDate = "2024-12-18",
    averageRating = 7.422,
    voteCount = 1934
).toMovieUi()


