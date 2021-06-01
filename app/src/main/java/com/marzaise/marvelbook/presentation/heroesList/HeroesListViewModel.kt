package com.marzaise.marvelbook.presentation.heroesList

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.*
import com.marzaise.marvelbook.data.models.HeroModel
import com.marzaise.marvelbook.domain.usecases.GetMarvelListUseCase
import com.marzaise.recipesbook.components.paginator.PaginatorListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class HeroesListViewModel @Inject constructor(
    private val getMarvelListUseCase: GetMarvelListUseCase
) : ViewModel(), PaginatorListener {

    var heroesListLiveData: LiveData<List<HeroModel>?> = MutableLiveData<List<HeroModel>>()
    private val index: MutableStateFlow<Int> = MutableStateFlow(0)

    val isLoading: ObservableBoolean = ObservableBoolean(true)

    fun loadHeroes() {

        heroesListLiveData = index.asLiveData().switchMap { page ->
            getMarvelListUseCase.invoke(
                page,
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

    override fun loadNewPage() {
        index.value++
    }
}