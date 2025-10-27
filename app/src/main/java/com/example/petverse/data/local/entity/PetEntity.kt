package com.example.petverse.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.petverse.data.local.converter.DateConverter
import com.example.petverse.data.local.converter.StringListConverter
import java.util.Date

@Entity(tableName = "pets")
@TypeConverters(DateConverter::class, StringListConverter::class)
data class PetEntity(
    @PrimaryKey
    val id: String,
    val ownerId: String,
    val name: String,
    val species: String, // "dog" or "cat"
    val breed: String? = null,
    val sex: String, // "male", "female"
    val ageMonths: Int,
    val weightKg: Double? = null,
    val bio: String? = null,
    val temperament: List<String> = emptyList(), // friendly_with_kids, friendly_with_dogs, etc.
    val lookingStatus: String? = null, // "ready_for_adoption", "looking_for_mate", "just_browsing"
    val galleryCount: Int = 0,
    val bloodlineParentId: String? = null,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)