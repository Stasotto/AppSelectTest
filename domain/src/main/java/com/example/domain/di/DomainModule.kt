package com.example.domain.di

import com.example.domain.repository.MovieRepository
import com.example.domain.usecases.GetMoviesUseCase
import com.example.domain.usecases.GetMoviesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [DomainBindModule::class])
class DomainModule {
    @Provides
    fun provideGetMoviesUseCaseImpl(repository: MovieRepository) = GetMoviesUseCaseImpl(repository)
}

@Module
interface DomainBindModule {
    @Suppress("FunctionName")
    @Binds
    fun bindGetMoviesUseCaseImpl_to_MoviesUseCase(useCaseImpl: GetMoviesUseCaseImpl): GetMoviesUseCase
}