package com.marzaise.marvelbook.data.net.models

data class MarvelHeroResponse(
    val name: String = "",
    val thumbnail: MarvelHeroThumbnail = MarvelHeroThumbnail(),
    val description: String = ""
)