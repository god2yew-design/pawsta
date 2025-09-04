package com.example.petverse.domain.usecase

import com.example.petverse.di.IoDispatcher
import com.example.petverse.domain.model.Post
import com.example.petverse.domain.repository.PostRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class GetPostsUseCase(
    private val postRepository: PostRepository,
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher
) : BaseUseCaseNoParams<Flow<List<Post>>>(coroutineDispatcher) {

    override suspend fun execute(): Flow<List<Post>> {
        return postRepository.getPosts()
    }
}