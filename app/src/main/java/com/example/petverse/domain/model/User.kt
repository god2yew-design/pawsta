package com.example.petverse.domain.model

import java.util.Date

data class User(
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

data class UserWithPets(
    val user: User,
    val pets: List<Pet> = emptyList()
)