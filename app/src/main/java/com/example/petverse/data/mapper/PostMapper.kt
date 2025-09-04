package com.example.petverse.data.mapper

import com.example.petverse.data.local.entity.PostEntity
import com.example.petverse.domain.model.MediaType
import com.example.petverse.domain.model.Post
import com.example.petverse.domain.model.User

fun PostEntity.toDomain(): Post {
    return Post(
        id = id,
        author = User(
            id = authorUserId,
            name = "User $authorUserId", // TODO: Get from UserEntity
            email = "",
            avatarUrl = null,
            bio = null,
            location = null,
            isBusiness = false,
            badges = emptyList()
        ),
        pet = null, // TODO: Get from PetEntity if petId is not null
        mediaType = when (mediaType) {
            "photo" -> MediaType.PHOTO
            "video" -> MediaType.VIDEO
            "text" -> MediaType.TEXT
            else -> MediaType.TEXT
        },
        mediaUrl = mediaUrl,
        caption = caption,
        tags = tags,
        likeCount = likeCount,
        commentCount = commentCount,
        isLikedByCurrentUser = isLikedByCurrentUser,
        comments = emptyList(), // TODO: Load comments separately
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun Post.toEntity(): PostEntity {
    return PostEntity(
        id = id,
        authorUserId = author.id,
        petId = pet?.id,
        mediaType = when (mediaType) {
            MediaType.PHOTO -> "photo"
            MediaType.VIDEO -> "video"
            MediaType.TEXT -> "text"
        },
        mediaUrl = mediaUrl,
        caption = caption,
        tags = tags,
        likeCount = likeCount,
        commentCount = commentCount,
        isLikedByCurrentUser = isLikedByCurrentUser,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}