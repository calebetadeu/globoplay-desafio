package com.calebetadeu.globoplaychallenge.di

import android.app.Application
import com.calebetadeu.globoplaychallenge.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class GloboPlayApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GloboPlayApp)
            androidLogger()
            modules(homeModule)
        }
    }
}