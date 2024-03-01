package com.lobanov.app.android

import android.app.Application
import com.lobanov.app.di.getCommonModules
import org.koin.core.context.startKoin

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin { 
            modules(getCommonModules())
        }
    }
}