package com.marzaise.marvelbook.domain.usecases

import com.marzaise.marvelbook.data.local.HeroModel
import com.marzaise.marvelbook.data.repository.MarvelRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class GetMarvelListUseCase @Inject constructor(private val marvelRepository: MarvelRepository): UseCase<List<HeroModel>, Int?>() {

    override suspend fun run(
        page: Int?,
        onProgress: (() -> Unit)?,
        onSuccess: (() -> Unit)?,
        onError: ((String?) -> Unit)?
    ): List<HeroModel> {
        return marvelRepository.getHeroesList()
    }
}