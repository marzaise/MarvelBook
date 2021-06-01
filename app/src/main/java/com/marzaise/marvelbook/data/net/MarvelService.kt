package com.marzaise.marvelbook.data.net

import com.marzaise.marvelbook.data.net.models.MarvelListHeroesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

    @GET("api")
    suspend fun getRecipesList(@Query("p") page: Int = 1): MarvelListHeroesResponse

}