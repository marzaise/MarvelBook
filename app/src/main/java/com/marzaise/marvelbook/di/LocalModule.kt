package com.marzaise.marvelbook.di

import android.app.Application
import androidx.room.Room
import com.marzaise.marvelbook.data.local.AppDatabase
import com.marzaise.marvelbook.data.local.HeroDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application
    ): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java, "heroes-db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideHeroesDao(appDatabase: AppDatabase): HeroDao {
        return appDatabase.heroDao()
    }
}