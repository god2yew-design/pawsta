package com.example.petverse.domain.repository

import com.example.petverse.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    fun getPosts(): Flow<List<Post>>

    fun getPostById(postId: String): Flow<Post?>

    fun getPostsByUserId(userId: String): Flow<List<Post>>

    fun getPostsByPetId(petId: String): Flow<List<Post>>

    suspend fun createPost(post: Post): Result<Post>

    suspend fun updatePost(post: Post): Result<Post>

    suspend fun deletePost(postId: String): Result<Unit>

    suspend fun likePost(postId: String): Result<Unit>

    suspend fun unlikePost(postId: String): Result<Unit>
}