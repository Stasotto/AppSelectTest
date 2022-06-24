package com.example.appselecttest

import android.app.Application
import android.content.Context
import com.example.appselecttest.di.AppComponent
import com.example.appselecttest.di.DaggerAppComponent

class AppSelectTestApplication : Application() {

    lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is AppSelectTestApplication -> appComponent
        else -> applicationContext.appComponent
    }

