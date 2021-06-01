package com.marzaise.marvelbook.di

import com.marzaise.marvelbook.data.net.MarvelService
import com.marzaise.marvelbook.domain.remote.MarvelRemote
import com.marzaise.marvelbook.data.net.remote.MarvelRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideMarvelRepository(marvelService: MarvelService): MarvelRemote {
        return MarvelRemoteImpl(marvelService)
    }
}