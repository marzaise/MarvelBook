package com.marzaise.marvelbook.data.repository.remote

import com.marzaise.marvelbook.data.net.MarvelService
import com.marzaise.marvelbook.data.net.models.MarvelListHeroesResponse
import javax.inject.Inject

class MarvelRemoteImpl @Inject constructor(private val marvelService: MarvelService) :
        MarvelRemote {

    override suspend fun getHeroesList(): MarvelListHeroesResponse =
        marvelService.getHeroesList()

}