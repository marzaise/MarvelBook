package com.marzaise.marvelbook.presentation.heroDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marzaise.marvelbook.data.models.HeroModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class HeroDetailsViewModel @Inject constructor(
) : ViewModel() {

    private val _hero = MutableLiveData<HeroModel>()
    val hero: LiveData<HeroModel> get() = _hero

    fun loadHeroe(heroe: HeroModel){
        this._hero.value = heroe
    }
}
