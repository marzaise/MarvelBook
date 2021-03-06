package com.marzaise.marvelbook.data.net

import com.marzaise.marvelbook.data.net.models.MarvelListHeroesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

    @GET("characters")
    suspend fun getHeroesList(@Query("offset") offset: Int, @Query("limit") limit: Int): MarvelListHeroesResponse

}