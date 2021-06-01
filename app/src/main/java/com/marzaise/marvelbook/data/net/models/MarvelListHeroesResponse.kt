package com.marzaise.marvelbook.data.net.models

import com.google.gson.annotations.SerializedName

data class MarvelListHeroesResponse(
    @SerializedName("data")
    val heroesData: MarvelHeroesResponse
)