package com.marzaise.marvelbook.viewModel

import com.marzaise.marvelbook.FakeData.LIST_HEROES_DOMAIN
import com.marzaise.marvelbook.InstantTaskExecutorRule
import com.marzaise.marvelbook.MainCoroutinesRule
import com.marzaise.marvelbook.components.coroutines.DispatcherProvider
import com.marzaise.marvelbook.data.repository.MarvelRepositoryImpl
import com.marzaise.marvelbook.domain.usecases.GetMarvelListUseCase
import com.marzaise.marvelbook.domain.usecases.InsertHeroLocalUseCase
import com.marzaise.marvelbook.getValue
import com.marzaise.marvelbook.presentation.heroesList.HeroesListViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HeroListViewModelTest {

    private val page = 0
    @get:Rule
    val mainCoroutineRule = MainCoroutinesRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var marvelRepositoryImpl: MarvelRepositoryImpl
    lateinit var viewModel: HeroesListViewModel

    lateinit var getMarvelListUseCase: GetMarvelListUseCase
    lateinit var insertHeroLocalUseCase: InsertHeroLocalUseCase

    @MockK
    lateinit var dispatcherProvider: DispatcherProvider

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        getMarvelListUseCase = GetMarvelListUseCase(marvelRepositoryImpl)
        insertHeroLocalUseCase = InsertHeroLocalUseCase(marvelRepositoryImpl)
        viewModel = HeroesListViewModel(getMarvelListUseCase, insertHeroLocalUseCase, dispatcherProvider)
    }

    @Test
    fun `when the heroes list is not empty`() = runBlocking {
        val heroes = LIST_HEROES_DOMAIN
        coEvery { marvelRepositoryImpl.getHeroesList(page) } returns heroes
        coEvery { dispatcherProvider.io() } returns mainCoroutineRule.getMainDispatcher()
        viewModel.loadHeroes()

        assert(viewModel.isLoading.get())
        val heroesViewModel = getValue(viewModel.heroesListLiveData)
        assert(!viewModel.isLoading.get())
        assert(heroesViewModel!=null)
        assert(heroesViewModel!! == heroes)
        val errorMessage = getValue(viewModel.errorText)
        assert(errorMessage.isNullOrBlank())
    }

    @Test
    fun `when the heroes list is empty`() = runBlocking {
        coEvery { marvelRepositoryImpl.getHeroesList(page) } returns arrayListOf()
        coEvery { dispatcherProvider.io() } returns mainCoroutineRule.getMainDispatcher()
        viewModel.loadHeroes()

        assert(viewModel.isLoading.get())
        val heroesViewModel = getValue(viewModel.heroesListLiveData)
        assert(!viewModel.isLoading.get())
        assert(heroesViewModel!!.isEmpty())
    }

    @Test
    fun `when a hero is added as a favourite`() = runBlocking {
        val heroes = LIST_HEROES_DOMAIN
        coEvery { marvelRepositoryImpl.getHeroesList(page) } returns heroes
        coEvery { dispatcherProvider.io() } returns mainCoroutineRule.getMainDispatcher()

        viewModel.setHeroFavourite(heroes.first(), true)
        assert(viewModel.isLoading.get())
    }
}