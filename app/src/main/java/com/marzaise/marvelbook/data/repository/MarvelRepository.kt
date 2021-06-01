package com.marzaise.marvelbook.data.repository

import com.marzaise.marvelbook.data.local.HeroModel

interface MarvelRepository {
    suspend fun getHeroesList(): List<HeroModel>
}