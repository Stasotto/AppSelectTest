package com.example.data

import com.example.data.models.MovieEntity
import com.example.data.models.MovieResponse
import com.example.domain.models.MovieDomain


fun MovieResponse.toListMovieEntity(): List<MovieEntity> {
    return results.map { result ->
        MovieEntity(
            name = result.headline,
            description = result.summary_short,
            imageUrl = result.multimedia.src
        )
    }
}

fun MovieEntity.toMovieDomain() = MovieDomain(
    name = name,
    description = description,
    imageUrl = imageUrl
)