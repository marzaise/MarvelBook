package com.marzaise.marvelbook.usecase

import com.marzaise.marvelbook.FakeData.LIST_HEROES_DOMAIN
import com.marzaise.marvelbook.data.repository.MarvelRepositoryImpl
import com.marzaise.marvelbook.domain.usecases.GetMarvelListUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.time.ExperimentalTime

class GetMarvelListUseCaseTest {
    private val page = 1
    @MockK
    lateinit var marvelRepositoryImpl: MarvelRepositoryImpl

    lateinit var getMarvelListUseCase: GetMarvelListUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        getMarvelListUseCase = GetMarvelListUseCase(marvelRepositoryImpl)
    }

    @ExperimentalTime
    @Test
    fun `repository should retrieve heroes list`() = runBlocking {
        val heroesList = LIST_HEROES_DOMAIN
        coEvery { marvelRepositoryImpl.getHeroesList(page) } returns heroesList

        getMarvelListUseCase.invoke(page).collect{ res ->
            assert(res!=null)
            res?.let {
                assert(heroesList.size==res.size)
                assert(heroesList.first() == res.first())
                assert(heroesList.last() == res.last())
            }
        }
    }
}