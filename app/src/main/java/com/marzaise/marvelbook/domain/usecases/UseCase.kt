package com.marzaise.marvelbook.domain.usecases

import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import java.util.concurrent.CancellationException

abstract class UseCase<Type, in Params>() where Type : Any {

    abstract suspend fun run(
        params: Params?, onProgress: (() -> Unit)?, onSuccess: (() -> Unit)?,
        onError: ((String?) -> Unit)?
    ): Type

    fun invoke(
        params: Params? = null, onProgress: (() -> Unit)? = null, onSuccess: (() -> Unit)? = null,
        onError: ((String?) -> Unit)? = null
    ) = kotlinx.coroutines.flow.flow<Type?> {
        try {
            val result = run(params, onProgress, onSuccess, onError)
            emit(result)
            onSuccess?.let { it() }
        } catch (e: CancellationException) {
            e.printStackTrace()
            onError?.let { it(e.message ?: "Unknown CancellationException") }
        } catch (e: Exception) {
            e.printStackTrace()
            onError?.let { it(e.message ?: "Error ${e.cause}") }
        }
    }.onStart { onProgress?.let { it() } }.flowOn(kotlinx.coroutines.Dispatchers.IO)
}