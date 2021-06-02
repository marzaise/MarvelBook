package com.marzaise.marvelbook.components.coroutines

import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DispatcherProviderImpl @Inject constructor() : DispatcherProvider {
    override fun io() = Dispatchers.IO

    override fun main() = Dispatchers.Main

    override fun default() = Dispatchers.Default
}