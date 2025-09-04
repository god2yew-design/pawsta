package com.example.petverse.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.petverse.data.local.converter.DateConverter
import com.example.petverse.data.local.converter.StringListConverter
import java.util.Date

@Entity(tableName = "services")
@TypeConverters(DateConverter::class, StringListConverter::class)
data class ServiceEntity(
    @PrimaryKey
    val id: String,
    val providerUserId: String,
    val category: String, // "dog_walker", "dog_sitter", "groomer", "trainer"
    val title: String,
    val description: String,
    val priceCents: Int,
    val currency: String = "USD",
    val serviceAreaLat: Double? = null,
    val serviceAreaLng: Double? = null,
    val serviceAreaRadiusMeters: Int? = null,
    val ratingAvg: Double = 0.0,
    val ratingCount: Int = 0,
    val galleryUrls: List<String> = emptyList(),
    val badges: List<String> = emptyList(),
    val isAvailable: Boolean = true,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)