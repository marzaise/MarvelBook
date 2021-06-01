package com.marzaise.marvelbook.data.repository.remote

import android.util.Log
import com.marzaise.marvelbook.data.net.MarvelService
import com.marzaise.marvelbook.data.net.models.MarvelListHeroesResponse
import javax.inject.Inject

class MarvelRemoteImpl @Inject constructor(private val marvelService: MarvelService) :
        MarvelRemote {

    private val limitItems = 20

    override suspend fun getHeroesList(page: Int): MarvelListHeroesResponse{
        Log.d("marvelRepo", ""+limitItems*page+" "+limitItems)
        return marvelService.getHeroesList(limitItems*page, limitItems)
    }

}