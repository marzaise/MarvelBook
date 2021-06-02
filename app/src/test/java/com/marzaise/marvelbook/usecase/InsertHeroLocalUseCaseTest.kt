package com.marzaise.marvelbook.usecase

import com.marzaise.marvelbook.FakeData.LIST_HEROES_DOMAIN
import com.marzaise.marvelbook.data.repository.MarvelRepositoryImpl
import com.marzaise.marvelbook.domain.usecases.InsertHeroLocalUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.time.ExperimentalTime

class InsertHeroLocalUseCaseTest {
    private val page = 1
    @MockK
    lateinit var marvelRepositoryImpl: MarvelRepositoryImpl

    lateinit var insertHeroLocalUseCase: InsertHeroLocalUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        insertHeroLocalUseCase = InsertHeroLocalUseCase(marvelRepositoryImpl)
    }

    @ExperimentalTime
    @Test
    fun `repository should retrieve heroes list`() = runBlocking {
        val heroes = LIST_HEROES_DOMAIN
        coEvery { marvelRepositoryImpl.getHeroesList(page) } returns heroes

        val hero = heroes.first()
        hero.toggleFavorite()
        insertHeroLocalUseCase.invoke(hero).collect { res ->
            assert(res==Unit)
        }
    }
}