package com.marzaise.marvelbook.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.marzaise.marvelbook.data.local.models.HeroLocal

@Dao
interface HeroDao {
    @Query("SELECT * FROM HeroLocal WHERE isFavorite = 1")
    fun getAllFavouriteHeroes(): List<HeroLocal>

    @Query("SELECT isFavorite FROM HeroLocal WHERE name = :name")
    fun getIsFavourite(name: String): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(hero: HeroLocal)
}