package com.example.petverse.domain.model

import java.util.Date

data class Post(
    val id: String,
    val author: User,
    val pet: Pet? = null,
    val mediaType: MediaType,
    val mediaUrl: String? = null,
    val caption: String? = null,
    val tags: List<String> = emptyList(),
    val likeCount: Int = 0,
    val commentCount: Int = 0,
    val isLikedByCurrentUser: Boolean = false,
    val comments: List<Comment> = emptyList(),
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)

data class Comment(
    val id: String,
    val postId: String,
    val author: User,
    val text: String,
    val createdAt: Date = Date()
)

enum class MediaType(val displayName: String) {
    PHOTO("Photo"),
    VIDEO("Video"),
    TEXT("Text")
}