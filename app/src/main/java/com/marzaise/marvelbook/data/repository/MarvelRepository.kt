package com.marzaise.marvelbook.data.repository

import com.marzaise.marvelbook.data.models.HeroModel

interface MarvelRepository {
    suspend fun getHeroesList(page: Int): List<HeroModel>
}