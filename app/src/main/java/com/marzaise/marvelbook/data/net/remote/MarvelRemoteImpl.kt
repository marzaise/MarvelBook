package com.marzaise.marvelbook.data.net.remote

import com.marzaise.marvelbook.data.net.MarvelService
import com.marzaise.marvelbook.data.net.models.MarvelListHeroesResponse
import com.marzaise.marvelbook.domain.remote.MarvelRemote
import javax.inject.Inject

class MarvelRemoteImpl @Inject constructor(private val marvelService: MarvelService) :
    MarvelRemote {

    private val limitItems = 20

    override suspend fun getHeroesList(page: Int): MarvelListHeroesResponse{
        return marvelService.getHeroesList(limitItems*page, limitItems)
    }

}