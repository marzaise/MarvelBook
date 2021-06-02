package com.marzaise.marvelbook.data.net.models

data class HeroRemote(
    val name: String = "",
    val thumbnail: MarvelHeroThumbnail = MarvelHeroThumbnail(),
    val description: String = ""
)