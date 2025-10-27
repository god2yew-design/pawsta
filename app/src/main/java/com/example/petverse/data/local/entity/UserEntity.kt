package com.example.petverse.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.petverse.data.local.converter.DateConverter
import com.example.petverse.data.local.converter.StringListConverter
import java.util.Date

@Entity(tableName = "users")
@TypeConverters(DateConverter::class, StringListConverter::class)
data class UserEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val email: String,
    val avatarUrl: String? = null,
    val bio: String? = null,
    val location: String? = null,
    val isBusiness: Boolean = false,
    val badges: List<String> = emptyList(),
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)