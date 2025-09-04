package com.example.petverse.domain.model

import java.util.Date

data class Pet(
    val id: String,
    val ownerId: String,
    val name: String,
    val species: String, // "dog" or "cat"
    val breed: String? = null,
    val sex: String, // "male", "female"
    val ageMonths: Int,
    val weightKg: Double? = null,
    val bio: String? = null,
    val temperament: List<String> = emptyList(),
    val lookingStatus: String? = null,
    val galleryCount: Int = 0,
    val bloodlineParentId: String? = null,
    val photos: List<String> = emptyList(),
    val owner: User? = null,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)

enum class PetSpecies(val displayName: String) {
    DOG("Dog"),
    CAT("Cat")
}

enum class PetSex(val displayName: String) {
    MALE("Male"),
    FEMALE("Female")
}

enum class PetTemperament(val displayName: String) {
    FRIENDLY_WITH_KIDS("Friendly with Kids"),
    FRIENDLY_WITH_DOGS("Friendly with Dogs"),
    FRIENDLY_WITH_CATS("Friendly with Cats"),
    GOOD_WITH_STRANGERS("Good with Strangers"),
    ENERGETIC("Energetic"),
    CALM("Calm"),
    INDEPENDENT("Independent"),
    DEPENDENT("Dependent")
}

enum class PetLookingStatus(val displayName: String) {
    READY_FOR_ADOPTION("Ready for Adoption"),
    LOOKING_FOR_MATE("Looking for a Mate"),
    JUST_BROWSING("Just Browsing")
}