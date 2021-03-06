package com.marzaise.marvelbook

import com.marzaise.marvelbook.data.local.models.HeroLocal
import com.marzaise.marvelbook.data.net.models.HeroRemote
import com.marzaise.marvelbook.data.net.models.MarvelHeroThumbnail
import com.marzaise.marvelbook.data.net.models.MarvelHeroesResponse
import com.marzaise.marvelbook.data.net.models.MarvelListHeroesResponse
import com.marzaise.marvelbook.domain.models.HeroModel

object FakeData {
    const val DIVIDOR = "2"
    private val url_path = "https://www.example.com/"
    private val url_extension = "jpg"
    const val NAME = "Iron Man"
    const val DESCRIPTION = "Anthony Edward \"Tony\" Stark"
    val IMAGE = "$url_path.$url_extension"
    val IMAGE_2 = "$url_path$DIVIDOR.$url_extension"

    val IRON_MAN_LOCAL = HeroLocal(name = NAME, image = IMAGE, description = DESCRIPTION, isFavorite = false)

    val IRON_HERO_THUMBNAIL = MarvelHeroThumbnail(url_path, url_extension)
    val IRON_HERO_THUMBNAIL_2 = MarvelHeroThumbnail(url_path+DIVIDOR, url_extension)
    val IRON_MAN_REMOTE = HeroRemote(name = NAME, thumbnail = IRON_HERO_THUMBNAIL, description = DESCRIPTION)
    val IRON_MAN_REMOTE_2 = HeroRemote(name = NAME+DIVIDOR, thumbnail = IRON_HERO_THUMBNAIL_2, description = DESCRIPTION+DIVIDOR)

    val MARVEL_RESPONSE = MarvelHeroesResponse(listOf(IRON_MAN_REMOTE, IRON_MAN_REMOTE_2))
    val MARVEL_RESPONSE_LIST = MarvelListHeroesResponse(MARVEL_RESPONSE)

    val IRON_MAN_DOMAIN = HeroModel(name = NAME, image = IMAGE, description = DESCRIPTION, isFavorite = false)
    val IRON_MAN2_DOMAIN = HeroModel(name = NAME+DIVIDOR, image = IMAGE_2, description = DESCRIPTION+DIVIDOR, isFavorite = false)
    val LIST_HEROES_DOMAIN = listOf(IRON_MAN_DOMAIN, IRON_MAN2_DOMAIN)
}