package com.marzaise.marvelbook.di

import com.marzaise.marvelbook.data.local.HeroDao
import com.marzaise.marvelbook.domain.repository.MarvelRepository
import com.marzaise.marvelbook.data.repository.MarvelRepositoryImpl
import com.marzaise.marvelbook.domain.remote.MarvelRemote
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
    fun provideMarvelRepository(marvelRemote: MarvelRemote, heroesDao: HeroDao): MarvelRepository {
        return MarvelRepositoryImpl(marvelRemote, heroesDao)
    }
}