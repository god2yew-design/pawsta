package com.example.petverse.domain.model

import java.util.Date

data class Service(
    val id: String,
    val provider: User,
    val category: ServiceCategory,
    val title: String,
    val description: String,
    val priceCents: Int,
    val currency: String = "USD",
    val serviceArea: ServiceArea? = null,
    val rating: Rating = Rating(),
    val galleryUrls: List<String> = emptyList(),
    val badges: List<String> = emptyList(),
    val isAvailable: Boolean = true,
    val availability: List<AvailabilitySlot> = emptyList(),
    val reviews: List<Review> = emptyList(),
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)

data class ServiceArea(
    val latitude: Double,
    val longitude: Double,
    val radiusMeters: Int
)

data class Rating(
    val average: Double = 0.0,
    val count: Int = 0
)

data class AvailabilitySlot(
    val dayOfWeek: Int, // 1 = Monday, 7 = Sunday
    val startTime: String, // "09:00"
    val endTime: String    // "17:00"
)

data class Review(
    val id: String,
    val reviewer: User,
    val rating: Int, // 1-5
    val comment: String? = null,
    val mediaUrls: List<String> = emptyList(),
    val createdAt: Date = Date()
)

enum class ServiceCategory(val displayName: String) {
    DOG_WALKER("Dog Walker"),
    DOG_SITTER("Dog Sitter"),
    GROOMER("Groomer"),
    TRAINER("Trainer"),
    OTHER("Other")
}