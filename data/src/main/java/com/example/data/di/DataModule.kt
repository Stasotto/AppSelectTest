package com.example.data.di

import com.example.data.MovieRepositoryImpl
import com.example.data.storage.NetworkStorage
import com.example.data.storage.retrofit.MoviesApi
import com.example.data.storage.retrofit.NetworkStorageImpl
import com.example.data.storage.retrofit.RetrofitClient
import com.example.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [DataBindModule::class])
class DataModule {

    @Provides
    fun provideMovieRepository(networkStorage: NetworkStorage): MovieRepository =
        MovieRepositoryImpl(networkStorage)


    @Provides
    fun provideMoviesApi() = RetrofitClient.getMoviesApi()

    @Provides
    fun provideNetworkStorageImpl(api: MoviesApi) = NetworkStorageImpl(api)
}

@Module
interface DataBindModule {
    @Suppress("FunctionName")
    @Binds
    fun bindNetworkStorageImpl_to_NetworkStorage(storage: NetworkStorageImpl): NetworkStorage
}