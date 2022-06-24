package com.example.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.storage.NetworkStorage
import com.example.domain.models.MovieDomain
import com.example.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class MovieRepositoryImpl(private val network: NetworkStorage) : MovieRepository {

    private companion object {
        const val PAGE_SIZE = 20
    }
// Это для загрузки данный без пагинации
//    override suspend fun getMovies(): List<MovieDomain> {
//        return withContext(Dispatchers.IO) {
//            network.getMovies(0).toListMovieEntity().map { movieEntity ->
//                movieEntity.toMovieDomain()
//            }
//        }
//    }

    override suspend fun getPagedMovies(): Flow<PagingData<MovieDomain>> {
        val loader: MoviePageLoader = { offset ->
            network.getMovies(offset)
        }
        return withContext(Dispatchers.IO) {
            Pager(
                config = PagingConfig(
                    pageSize = PAGE_SIZE,
                    enablePlaceholders = true
                ),
                pagingSourceFactory = {
                    MoviesPagingSource(loader)
                }
            ).flow
        }
    }
}