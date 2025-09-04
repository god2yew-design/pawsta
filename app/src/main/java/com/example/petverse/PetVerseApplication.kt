package com.example.petverse

import android.app.Application
import com.jakewharton.timber.Timber
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PetVerseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize Timber for logging
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        // TODO: Initialize Firebase
        // FirebaseApp.initializeApp(this)

        // TODO: Initialize Stripe
        // PaymentConfiguration.init(applicationContext, BuildConfig.STRIPE_PUBLISHABLE_KEY)
    }
}