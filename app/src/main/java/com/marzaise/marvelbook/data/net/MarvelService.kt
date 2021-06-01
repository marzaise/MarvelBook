package com.marzaise.marvelbook.data.net

import com.marzaise.marvelbook.data.net.models.MarvelListHeroesResponse
import retrofit2.http.GET

interface MarvelService {

    @GET("characters")
    suspend fun getHeroesList(): MarvelListHeroesResponse

}