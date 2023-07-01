package com.example.solicytaskproject

import android.app.Application
import com.example.solicytaskproject.di.messageModule
import com.example.solicytaskproject.di.repositoryModule
import com.example.solicytaskproject.di.useCaseModule
import com.example.solicytaskproject.di.viewModelModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GmailApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(applicationContext)
            modules(listOf(repositoryModule, viewModelModule, messageModule, useCaseModule))
        }
    }
}