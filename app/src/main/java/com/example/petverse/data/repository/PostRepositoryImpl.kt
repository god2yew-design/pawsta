package com.example.petverse.data.repository

import com.example.petverse.data.local.dao.PostDao
import com.example.petverse.domain.model.Post
import com.example.petverse.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepositoryImpl @Inject constructor(
    private val postDao: PostDao
) : PostRepository {

    override fun getPosts(): Flow<List<Post>> {
        return postDao.getAllPosts().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override fun getPostById(postId: String): Flow<Post?> {
        return postDao.getPostById(postId).map { it?.toDomain() }
    }

    override fun getPostsByUserId(userId: String): Flow<List<Post>> {
        return postDao.getPostsByUserId(userId).map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override fun getPostsByPetId(petId: String): Flow<List<Post>> {
        return postDao.getPostsByPetId(petId).map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun createPost(post: Post): Result<Post> {
        return try {
            // TODO: Implement with actual data source (Supabase)
            // For now, return success with the post
            Result.success(post)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updatePost(post: Post): Result<Post> {
        return try {
            // TODO: Implement with actual data source
            Result.success(post)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun deletePost(postId: String): Result<Unit> {
        return try {
            // TODO: Implement with actual data source
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun likePost(postId: String): Result<Unit> {
        return try {
            postDao.incrementLikeCount(postId)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun unlikePost(postId: String): Result<Unit> {
        return try {
            postDao.decrementLikeCount(postId)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}