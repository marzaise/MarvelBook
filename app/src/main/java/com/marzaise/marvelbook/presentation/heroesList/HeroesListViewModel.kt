package com.marzaise.marvelbook.presentation.heroesList

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.*
import com.marzaise.marvelbook.domain.models.HeroModel
import com.marzaise.marvelbook.domain.usecases.GetMarvelListUseCase
import com.marzaise.marvelbook.domain.usecases.InsertHeroLocalUseCase
import com.marzaise.recipesbook.components.paginator.PaginatorListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class HeroesListViewModel @Inject constructor(
    private val getMarvelListUseCase: GetMarvelListUseCase,
    private val insertHeroLocalUseCase: InsertHeroLocalUseCase,
) : ViewModel(), PaginatorListener {

    private val _errorText: MutableLiveData<String> = MutableLiveData<String>()
    val errorText: LiveData<String> get() = _errorText

    var heroesListLiveData: LiveData<List<HeroModel>?> = MutableLiveData<List<HeroModel>>()
    private val index: MutableStateFlow<Int> = MutableStateFlow(0)

    val isLoading: ObservableBoolean = ObservableBoolean(true)

    fun loadHeroes() {
        heroesListLiveData = index.asLiveData().switchMap { page ->
            getMarvelListUseCase.invoke(
                page,
                onProgress = {
                    isLoading.set(true)
                },
                onSuccess = {
                    isLoading.set(false)
                },
                onError = {
                    isLoading.set(false)
                    _errorText.postValue(it)
                }
            ).asLiveData(Dispatchers.IO)
        }
    }

    override fun loadNewPage() {
        index.value++
    }

    fun setHeroFavourite(hero: HeroModel, isFavourite: Boolean) {
        hero.isFavorite = isFavourite
        Log.d("favoriteThing", "calling")
        viewModelScope.launch(Dispatchers.IO) {
            insertHeroLocalUseCase.invoke(hero,
                onError = {
                    _errorText.postValue(it)
                }
            ).collect()
        }
    }
}