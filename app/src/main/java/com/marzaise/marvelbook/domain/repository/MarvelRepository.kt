package com.marzaise.marvelbook.domain.repository

import com.marzaise.marvelbook.domain.models.HeroModel

interface MarvelRepository {
    suspend fun getHeroesList(page: Int): List<HeroModel>
    suspend fun insertHeroLocal(hero: HeroModel?)
}