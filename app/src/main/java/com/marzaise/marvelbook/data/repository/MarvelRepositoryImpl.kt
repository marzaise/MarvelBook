package com.marzaise.marvelbook.data.repository

import com.marzaise.marvelbook.data.local.HeroDao
import com.marzaise.marvelbook.data.local.toLocalModel
import com.marzaise.marvelbook.domain.models.HeroModel
import com.marzaise.marvelbook.data.net.models.toDomainModel
import com.marzaise.marvelbook.domain.remote.MarvelRemote
import com.marzaise.marvelbook.domain.repository.MarvelRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MarvelRepositoryImpl @Inject constructor(private val marvelRemote: MarvelRemote, private val heroDao: HeroDao)
    : MarvelRepository {

    override suspend fun getHeroesList(page: Int): List<HeroModel> {
        val serverResponse = marvelRemote.getHeroesList(page)
        val heroesList = serverResponse.toDomainModel()
        for (hero in heroesList){
            hero.isFavorite = heroDao.getIsFavourite(hero.name)
        }
        return heroesList
    }

    override suspend fun insertHeroLocal(hero: HeroModel?) {
        hero?.let {
            heroDao.insert(hero.toLocalModel())
        }
    }
}