package com.marzaise.marvelbook.di

import com.marzaise.marvelbook.data.repository.MarvelRepository
import com.marzaise.marvelbook.data.repository.MarvelRepositoryImpl
import com.marzaise.marvelbook.data.repository.remote.MarvelRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMarvelRepository(marvelRemote: MarvelRemote): MarvelRepository {
        return MarvelRepositoryImpl(marvelRemote)
    }
}