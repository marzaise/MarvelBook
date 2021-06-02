package com.marzaise.marvelbook.presentation.heroDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marzaise.marvelbook.components.coroutines.DispatcherProvider
import com.marzaise.marvelbook.domain.models.HeroModel
import com.marzaise.marvelbook.domain.usecases.InsertHeroLocalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class HeroDetailsViewModel @Inject constructor(
    private val insertHeroLocalUseCase: InsertHeroLocalUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _errorText: MutableLiveData<String> = MutableLiveData<String>()
    val errorText: LiveData<String> get() = _errorText

    private val _hero = MutableLiveData<HeroModel>()
    val hero: LiveData<HeroModel> get() = _hero

    fun loadHero(hero: HeroModel) {
        this._hero.value = hero
    }

    fun favoriteClick(){
        hero.value!!.toggleFavorite()
        _hero.postValue(hero.value)
        viewModelScope.launch(dispatcherProvider.io()) {
            insertHeroLocalUseCase.invoke(hero.value,
                onError = {
                    _errorText.postValue(it)
                }
            ).collect()
        }
    }
}
