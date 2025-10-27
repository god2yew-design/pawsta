package com.example.petverse.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.petverse.data.local.dao.*
import com.example.petverse.data.local.entity.*

@Database(
    entities = [
        UserEntity::class,
        PetEntity::class,
        PostEntity::class,
        ServiceEntity::class
        // TODO: Add other entities as they are created
    ],
    version = 1,
    exportSchema = true
)
abstract class PetVerseDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun petDao(): PetDao
    abstract fun postDao(): PostDao
    abstract fun serviceDao(): ServiceDao

    companion object {
        const val DATABASE_NAME = "petverse_database"
    }
}