package com.example.petverse.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class BaseUseCase<in P, out R>(
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(parameters: P): Result<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let { Result.success(it) }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    protected abstract suspend fun execute(parameters: P): R
}

abstract class BaseUseCaseNoParams<out R>(
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): Result<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute().let { Result.success(it) }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    protected abstract suspend fun execute(): R
}