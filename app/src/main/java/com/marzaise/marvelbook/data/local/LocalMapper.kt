package com.marzaise.marvelbook.data.local

import com.marzaise.marvelbook.data.local.models.HeroLocal
import com.marzaise.marvelbook.domain.models.HeroModel

internal fun HeroModel.toLocalModel(): HeroLocal =
    HeroLocal(
        name = this.name,
        image = this.image,
        description = this.description,
        isFavorite = this.isFavorite
    )

internal fun HeroLocal.toDomainModel(): HeroModel =
    HeroModel(
        name = this.name,
        image = this.image,
        description = this.description,
        isFavorite = this.isFavorite
    )