package com.marzaise.marvelbook.domain.remote

import com.marzaise.marvelbook.data.net.models.MarvelListHeroesResponse

interface MarvelRemote {
    suspend fun getHeroesList(page: Int): MarvelListHeroesResponse
}