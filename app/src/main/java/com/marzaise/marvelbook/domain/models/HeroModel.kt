package com.marzaise.marvelbook.domain.models

import android.os.Parcelable
import com.marzaise.marvelbook.data.local.models.HeroLocal
import com.marzaise.marvelbook.data.net.models.HeroRemote
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HeroModel(
    var name: String,
    val image: String,
    val description: String,
    var isFavorite: Boolean
) : Parcelable {
    fun toggleFavorite() {
        this.isFavorite = !this.isFavorite
    }

    override fun equals(other: Any?): Boolean {
        if (other is HeroLocal) {
            val heroLocal: HeroLocal = other
            return (this.name == heroLocal.name &&
                    this.description == heroLocal.description &&
                    this.image == heroLocal.image &&
                    this.isFavorite == heroLocal.isFavorite)
        } else if (other is HeroRemote) {
            val heroRemote: HeroRemote = other
            return (this.name == heroRemote.name &&
                    this.description == heroRemote.description &&
                    this.image == heroRemote.thumbnail.getUrl())
        }
        return super.equals(other)
    }
}