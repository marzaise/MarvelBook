package com.marzaise.marvelbook.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HeroModel(
    val name: String,
    val image: String,
    val description: String
): Parcelable