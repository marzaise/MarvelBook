package com.marzaise.marvelbook.data.net.models

data class MarvelHeroThumbnail(
    val path: String = "",
    val extension: String = ""
) {
    fun getUrl(): String{
        return "$path.$extension"
    }
}