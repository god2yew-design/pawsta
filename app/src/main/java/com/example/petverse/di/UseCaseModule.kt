package com.example.petverse.di

import com.example.petverse.domain.repository.PostRepository
import com.example.petverse.domain.usecase.GetPostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetPostsUseCase(
        postRepository: PostRepository,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): GetPostsUseCase {
        return GetPostsUseCase(postRepository, ioDispatcher)
    }

    @Provides
    @Singleton
    @IoDispatcher
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher