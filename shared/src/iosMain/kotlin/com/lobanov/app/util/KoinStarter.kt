package com.lobanov.app.util

import com.lobanov.app.di.getCommonModules
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(getCommonModules())
    }
}