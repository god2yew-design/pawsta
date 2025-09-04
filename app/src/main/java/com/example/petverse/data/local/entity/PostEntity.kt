package com.example.petverse.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.petverse.data.local.converter.DateConverter
import com.example.petverse.data.local.converter.StringListConverter
import java.util.Date

@Entity(tableName = "posts")
@TypeConverters(DateConverter::class, StringListConverter::class)
data class PostEntity(
    @PrimaryKey
    val id: String,
    val authorUserId: String,
    val petId: String? = null,
    val mediaType: String, // "photo", "video", "text"
    val mediaUrl: String? = null,
    val caption: String? = null,
    val tags: List<String> = emptyList(),
    val likeCount: Int = 0,
    val commentCount: Int = 0,
    val isLikedByCurrentUser: Boolean = false,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)