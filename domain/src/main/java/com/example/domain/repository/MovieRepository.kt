package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.models.MovieDomain
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    // Это для загрузки данный без пагинации
//    suspend fun getMovies(): List<MovieDomain>
    suspend fun getPagedMovies(): Flow<PagingData<MovieDomain>>
}