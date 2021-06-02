package com.marzaise.marvelbook.components.coroutines

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    fun io(): CoroutineDispatcher

    fun main(): CoroutineDispatcher

    fun default(): CoroutineDispatcher
}