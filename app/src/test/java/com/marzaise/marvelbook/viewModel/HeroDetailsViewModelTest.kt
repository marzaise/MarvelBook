package com.marzaise.marvelbook.viewModel

import com.marzaise.marvelbook.FakeData
import com.marzaise.marvelbook.InstantTaskExecutorRule
import com.marzaise.marvelbook.MainCoroutinesRule
import com.marzaise.marvelbook.components.coroutines.DispatcherProvider
import com.marzaise.marvelbook.data.repository.MarvelRepositoryImpl
import com.marzaise.marvelbook.domain.usecases.InsertHeroLocalUseCase
import com.marzaise.marvelbook.getValue
import com.marzaise.marvelbook.presentation.heroDetails.HeroDetailsViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HeroDetailsViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutinesRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var marvelRepositoryImpl: MarvelRepositoryImpl
    lateinit var viewModel: HeroDetailsViewModel

    lateinit var insertHeroLocalUseCase: InsertHeroLocalUseCase

    @MockK
    lateinit var dispatcherProvider: DispatcherProvider

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        insertHeroLocalUseCase = InsertHeroLocalUseCase(marvelRepositoryImpl)
        viewModel = HeroDetailsViewModel(insertHeroLocalUseCase, dispatcherProvider)
    }

    @Test
    fun `when a hero is loaded`() = runBlocking {
        val hero = FakeData.IRON_MAN_DOMAIN
        coEvery { dispatcherProvider.io() } returns mainCoroutineRule.getMainDispatcher()
        viewModel.loadHero(hero)

        val heroViewModel = getValue(viewModel.hero)
        assert(heroViewModel == hero)
        val errorMessage = getValue(viewModel.errorText)
        assert(errorMessage.isNullOrBlank())
    }

    @Test
    fun `when the hero is added as favorite`() = runBlocking {
        val hero = FakeData.IRON_MAN_DOMAIN
        coEvery { dispatcherProvider.io() } returns mainCoroutineRule.getMainDispatcher()
        viewModel.loadHero(hero)
        viewModel.favoriteClick()
        val heroViewModel = getValue(viewModel.hero)
        assert(heroViewModel!!.isFavorite)
        val errorMessage = getValue(viewModel.errorText)
        assert(errorMessage.isNullOrBlank())
    }

}