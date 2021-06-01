package com.marzaise.marvelbook.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HeroModel(
    var name: String,
    val image: String,
    val description: String,
    var isFavorite: Boolean
): Parcelable{
    public fun toggleFavorite(){
        this.isFavorite = !this.isFavorite
    }
}