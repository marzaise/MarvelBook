package com.marzaise.marvelbook.data.repository.remote

import com.marzaise.marvelbook.data.net.models.MarvelListHeroesResponse

interface MarvelRemote {
    suspend fun getHeroesList(): MarvelListHeroesResponse
}