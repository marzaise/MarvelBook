package com.marzaise.marvelbook.data.net.models

import com.marzaise.marvelbook.domain.models.HeroModel

internal fun HeroRemote.toDomainModel(): HeroModel =
    HeroModel(
        name = this.name,
        image = this.thumbnail.path + "." + this.thumbnail.extension,
        description = this.description,
        isFavorite = false
    )

internal fun MarvelListHeroesResponse.toDomainModel(): List<HeroModel> =
    this.heroesData.superheroes.map { it.toDomainModel() }
