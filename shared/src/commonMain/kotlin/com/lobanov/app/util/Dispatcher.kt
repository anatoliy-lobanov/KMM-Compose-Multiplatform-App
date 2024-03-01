package com.lobanov.app.util

import kotlinx.coroutines.CoroutineDispatcher

interface Dispatcher {
    val io: CoroutineDispatcher
}

expect fun provideDispatcher(): Dispatcher