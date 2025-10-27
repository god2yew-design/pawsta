package com.example.petverse.data.local.dao

import androidx.room.*
import com.example.petverse.data.local.entity.PetEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PetDao {

    @Query("SELECT * FROM pets WHERE id = :petId")
    fun getPetById(petId: String): Flow<PetEntity?>

    @Query("SELECT * FROM pets WHERE ownerId = :ownerId")
    fun getPetsByOwnerId(ownerId: String): Flow<List<PetEntity>>

    @Query("SELECT * FROM pets")
    fun getAllPets(): Flow<List<PetEntity>>

    @Query("SELECT * FROM pets WHERE species = :species")
    fun getPetsBySpecies(species: String): Flow<List<PetEntity>>

    @Query("SELECT * FROM pets WHERE breed = :breed")
    fun getPetsByBreed(breed: String): Flow<List<PetEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPet(pet: PetEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPets(pets: List<PetEntity>)

    @Update
    suspend fun updatePet(pet: PetEntity)

    @Delete
    suspend fun deletePet(pet: PetEntity)

    @Query("DELETE FROM pets")
    suspend fun deleteAllPets()
}