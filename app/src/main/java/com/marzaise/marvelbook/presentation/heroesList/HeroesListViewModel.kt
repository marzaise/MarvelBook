package com.marzaise.marvelbook.presentation.heroesList

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.*
import com.marzaise.marvelbook.data.local.HeroModel
import com.marzaise.marvelbook.domain.usecases.GetMarvelListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class HeroesListViewModel @Inject constructor(
    private val getMarvelListUseCase: GetMarvelListUseCase
) : ViewModel() {

    var heroesListLiveData: LiveData<List<HeroModel>?> = MutableLiveData<List<HeroModel>>()
    private val index: MutableStateFlow<Int> = MutableStateFlow(1)

    val isLoading: ObservableBoolean = ObservableBoolean(true)

    fun loadHeroes() {

        heroesListLiveData = index.asLiveData().switchMap {
            getMarvelListUseCase.invoke(
                onProgress = {
                    isLoading.set(true)
                    Log.d("MainViewModel", "2onProgress")
                },
                onSuccess = {
                    isLoading.set(false)
                    Log.d("MainViewModel", "2onSuccess")
                }
            ) {
                isLoading.set(false)
                Log.d(
                    "MainViewModel", "2onError " + it
                )
            }.asLiveData(Dispatchers.IO)
        }
    }
}