package com.marzaise.marvelbook.data.repository

import com.marzaise.marvelbook.data.local.HeroModel
import com.marzaise.marvelbook.data.net.models.toDomainModel
import com.marzaise.marvelbook.data.repository.remote.MarvelRemote
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MarvelRepositoryImpl @Inject constructor(private val marvelRemote: MarvelRemote)
    : MarvelRepository {

    override suspend fun getHeroesList(): List<HeroModel> {
        val serverResponse = marvelRemote.getHeroesList()
        val heroesList = serverResponse.toDomainModel()
        return heroesList
    }
}