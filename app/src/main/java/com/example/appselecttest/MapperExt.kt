package com.example.appselecttest

import com.example.appselecttest.models.Movie
import com.example.domain.models.MovieDomain

fun MovieDomain.toMovie() = Movie(
    name = name,
    description = description,
    imageUrl = imageUrl
)