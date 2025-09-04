package com.example.petverse.data.local.dao

import androidx.room.*
import com.example.petverse.data.local.entity.PostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    @Query("SELECT * FROM posts WHERE id = :postId")
    fun getPostById(postId: String): Flow<PostEntity?>

    @Query("SELECT * FROM posts ORDER BY createdAt DESC")
    fun getAllPosts(): Flow<List<PostEntity>>

    @Query("SELECT * FROM posts WHERE authorUserId = :userId ORDER BY createdAt DESC")
    fun getPostsByUserId(userId: String): Flow<List<PostEntity>>

    @Query("SELECT * FROM posts WHERE petId = :petId ORDER BY createdAt DESC")
    fun getPostsByPetId(petId: String): Flow<List<PostEntity>>

    @Query("SELECT * FROM posts WHERE mediaType = :mediaType ORDER BY createdAt DESC")
    fun getPostsByMediaType(mediaType: String): Flow<List<PostEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: PostEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: List<PostEntity>)

    @Update
    suspend fun updatePost(post: PostEntity)

    @Delete
    suspend fun deletePost(post: PostEntity)

    @Query("DELETE FROM posts")
    suspend fun deleteAllPosts()

    @Query("UPDATE posts SET likeCount = likeCount + 1 WHERE id = :postId")
    suspend fun incrementLikeCount(postId: String)

    @Query("UPDATE posts SET likeCount = likeCount - 1 WHERE id = :postId")
    suspend fun decrementLikeCount(postId: String)

    @Query("UPDATE posts SET commentCount = commentCount + 1 WHERE id = :postId")
    suspend fun incrementCommentCount(postId: String)
}