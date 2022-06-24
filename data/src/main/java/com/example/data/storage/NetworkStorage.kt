package com.example.data.storage

import com.example.data.models.MovieResponse

interface NetworkStorage {

    suspend fun getMovies(offset: Int): MovieResponse
}