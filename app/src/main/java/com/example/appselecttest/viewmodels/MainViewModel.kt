package com.example.appselecttest.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.appselecttest.models.Movie
import com.example.appselecttest.toMovie
import com.example.domain.usecases.GetMoviesUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

@FlowPreview
@ExperimentalCoroutinesApi
class MainViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {
// Это для загрузки данных без пагинации
//    private val _movies = MutableLiveData<List<Movie>>()
//    val movies: LiveData<List<Movie>> get() = _movies

    var moviesFlow: Flow<PagingData<Movie>>? = null

    init {
        viewModelScope.launch {
            getMoviesUseCase.getPangedMovie().collect {
                moviesFlow = flowOf(it.map { movieDomain ->
                    movieDomain.toMovie()
                }).cachedIn(viewModelScope)

            }
        }
    }
// Это для загрузки данных без пагинации
    //    private fun loadMovies() {
//        viewModelScope.launch {
//            _movies.value = getMoviesUseCase.execute().map { movie ->
//                movie.toMovie()
//            }
//        }
//    }

    class Factory @Inject constructor(
        private val getMoviesUseCase: GetMoviesUseCase
    ) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(getMoviesUseCase) as T
        }
    }
}