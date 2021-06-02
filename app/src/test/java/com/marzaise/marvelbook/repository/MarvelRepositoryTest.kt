package com.marzaise.marvelbook.repository

import com.marzaise.marvelbook.FakeData.MARVEL_RESPONSE_LIST
import com.marzaise.marvelbook.data.local.HeroDao
import com.marzaise.marvelbook.data.repository.MarvelRepositoryImpl
import com.marzaise.marvelbook.domain.remote.MarvelRemote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class MarvelRepositoryTest {
    private lateinit var marvelRepositoryImpl: MarvelRepositoryImpl
    private val page = 1

    @MockK
    lateinit var marvelRemote: MarvelRemote

    @MockK
    lateinit var heroDao: HeroDao

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)

        marvelRepositoryImpl = MarvelRepositoryImpl(marvelRemote, heroDao)
    }

    @Test
    fun `repository should retrieve heroes list`() = runBlocking {
        val initList = MARVEL_RESPONSE_LIST
        coEvery { marvelRemote.getHeroesList(page) } returns initList
        coEvery { heroDao.getIsFavourite(initList.heroesData.superheroes.first().name) } returns false
        coEvery { heroDao.getIsFavourite(initList.heroesData.superheroes.last().name) } returns false

        val result = marvelRepositoryImpl.getHeroesList(page)
        assert(result.size == initList.heroesData.superheroes.size)
        assert(result.first().equals(initList.heroesData.superheroes.first()))
        assert(result.last().equals(initList.heroesData.superheroes.last()))
    }

    @Test
    fun `repository should retrieve empty list`() = runBlocking {
        val responseModel = MARVEL_RESPONSE_LIST
        responseModel.heroesData.superheroes = arrayListOf()

        coEvery { marvelRemote.getHeroesList(page) } returns responseModel

        val result = marvelRepositoryImpl.getHeroesList(page)
        assert(result.isEmpty())
    }

    @Test
    fun `repository should save favorite hero`() = runBlocking {
        val initList = MARVEL_RESPONSE_LIST
        coEvery { marvelRemote.getHeroesList(page) } returns initList
        coEvery { heroDao.getIsFavourite(initList.heroesData.superheroes.first().name) } returns true
        coEvery { heroDao.getIsFavourite(initList.heroesData.superheroes.last().name) } returns false

        val result = marvelRepositoryImpl.getHeroesList(page)
        assert(result.first().isFavorite)
        assert(!result.last().isFavorite)
    }
}