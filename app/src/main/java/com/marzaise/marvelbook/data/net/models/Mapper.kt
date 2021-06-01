package com.marzaise.marvelbook.data.net.models

import com.marzaise.marvelbook.data.local.HeroModel

internal fun MarvelHeroResponse.toDomainModel(): HeroModel =
    HeroModel(
        name = this.name
    )

internal fun MarvelListHeroesResponse.toDomainModel(): List<HeroModel> =
    this.heroesData.superheroes.map { it.toDomainModel() }
