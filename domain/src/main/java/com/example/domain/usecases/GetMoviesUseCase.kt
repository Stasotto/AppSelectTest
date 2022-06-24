package com.example.domain.usecases

import androidx.paging.PagingData
import com.example.domain.models.MovieDomain
import com.example.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

interface GetMoviesUseCase {

    suspend fun getPangedMovie(): Flow<PagingData<MovieDomain>>
// Это для загрузки данных без пагинации
//    =suspend fun execute(): List<MovieDomain>
}

class GetMoviesUseCaseImpl(private val repository: MovieRepository) : GetMoviesUseCase {
    override suspend fun getPangedMovie(): Flow<PagingData<MovieDomain>> {
        return repository.getPagedMovies()
    }
// Это для загрузки данных без пагинации
//    override suspend fun execute(): List<MovieDomain> {
//        return repository.getMovies()
//    }

}