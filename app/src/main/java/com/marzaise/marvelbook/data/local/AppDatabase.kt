package com.marzaise.marvelbook.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.marzaise.marvelbook.data.local.models.HeroLocal

@Database(entities = [HeroLocal::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

  abstract fun heroDao(): HeroDao
}
