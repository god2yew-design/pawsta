package com.example.petverse.ui.navigation

object NavigationRoutes {
    // Main tabs
    const val FEED = "feed"
    const val VIDEOS = "videos"
    const val SERVICES = "services"
    const val TOURS = "tours"
    const val PROFILE = "profile"

    // Auth
    const val AUTH = "auth"
    const val LOGIN = "login"
    const val SIGNUP = "signup"

    // Onboarding
    const val ONBOARDING = "onboarding"
    const val PET_SETUP = "pet_setup"

    // Pet related
    const val PET_PROFILE = "pet_profile/{petId}"
    const val PET_EDIT = "pet_edit/{petId}"

    // User related
    const val USER_PROFILE = "user_profile/{userId}"
    const val USER_EDIT = "user_edit"

    // Services
    const val SERVICE_DETAIL = "service_detail/{serviceId}"
    const val SERVICE_BOOKING = "service_booking/{serviceId}"
    const val BOOKINGS = "bookings"

    // Messages
    const val MESSAGES = "messages"
    const val CHAT = "chat/{chatId}"

    // Groups
    const val GROUPS = "groups"
    const val GROUP_DETAIL = "group_detail/{groupId}"

    // Adoptions
    const val ADOPTIONS = "adoptions"
    const val ADOPTION_DETAIL = "adoption_detail/{adoptionId}"

    // Breeder verification
    const val BREEDER_VERIFICATION = "breeder_verification"

    // AI Analysis
    const val AI_ANALYZE = "ai_analyze"

    // Tips
    const val TIPS = "tips"
    const val TIP_DETAIL = "tip_detail/{tipId}"

    // Settings
    const val SETTINGS = "settings"

    // Search
    const val SEARCH = "search"
}