package com.marzaise.marvelbook.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HeroLocal(
    @PrimaryKey
    val name: String,
    val image: String,
    val description: String,
    val isFavorite: Boolean
)