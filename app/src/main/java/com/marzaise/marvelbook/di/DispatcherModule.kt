package com.marzaise.marvelbook.di

import com.marzaise.marvelbook.components.coroutines.DispatcherProvider
import com.marzaise.marvelbook.components.coroutines.DispatcherProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Provides
    @Singleton
    fun bindsDispatcherProvider(): DispatcherProvider {
        return DispatcherProviderImpl()
    }
}