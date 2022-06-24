package com.example.appselecttest.di

import com.example.appselecttest.MainActivity
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@Component(modules = [AppModule::class])
interface AppComponent {

    @FlowPreview
    @ExperimentalCoroutinesApi
    fun inject(activity: MainActivity)
}