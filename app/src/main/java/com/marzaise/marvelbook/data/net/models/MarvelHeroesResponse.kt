package com.marzaise.marvelbook.data.net.models

import com.google.gson.annotations.SerializedName

data class MarvelHeroesResponse(
    @SerializedName("results")
    var superheroes: List<HeroRemote>
)