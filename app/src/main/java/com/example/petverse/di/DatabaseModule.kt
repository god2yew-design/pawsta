package com.example.petverse.di

import android.content.Context
import androidx.room.Room
import com.example.petverse.data.local.PetVerseDatabase
import com.example.petverse.data.local.dao.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providePetVerseDatabase(
        @ApplicationContext context: Context
    ): PetVerseDatabase {
        return Room.databaseBuilder(
            context,
            PetVerseDatabase::class.java,
            PetVerseDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: PetVerseDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    @Singleton
    fun providePetDao(database: PetVerseDatabase): PetDao {
        return database.petDao()
    }

    @Provides
    @Singleton
    fun providePostDao(database: PetVerseDatabase): PostDao {
        return database.postDao()
    }

    @Provides
    @Singleton
    fun provideServiceDao(database: PetVerseDatabase): ServiceDao {
        return database.serviceDao()
    }
}