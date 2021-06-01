package com.marzaise.marvelbook.domain.usecases

import com.marzaise.marvelbook.domain.models.HeroModel
import com.marzaise.marvelbook.domain.repository.MarvelRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class InsertHeroLocalUseCase @Inject constructor(private val marvelRepository: MarvelRepository): UseCase<Any, HeroModel>() {

    override suspend fun run(
        params: HeroModel?,
        onProgress: (() -> Unit)?,
        onSuccess: (() -> Unit)?,
        onError: ((String?) -> Unit)?
    ): Any {
        return marvelRepository.insertHeroLocal(params!!)
    }
}