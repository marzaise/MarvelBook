package com.marzaise.marvelbook.data.net.models

import com.marzaise.marvelbook.data.models.HeroModel

internal fun MarvelHeroResponse.toDomainModel(): HeroModel =
    HeroModel(
        name = this.name,
        image = this.thumbnail.path + "." + this.thumbnail.extension,
        description = this.description
    )

internal fun MarvelListHeroesResponse.toDomainModel(): List<HeroModel> =
    this.heroesData.superheroes.map { it.toDomainModel() }
