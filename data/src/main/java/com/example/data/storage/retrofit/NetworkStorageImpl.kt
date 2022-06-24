package com.example.data.storage.retrofit

import android.util.Log
import com.example.data.models.MovieResponse
import com.example.data.storage.NetworkStorage

class NetworkStorageImpl(private val api: MoviesApi) : NetworkStorage {

    override suspend fun getMovies(offset: Int): MovieResponse {
        return api.getMovies(offset = offset)
    }

}