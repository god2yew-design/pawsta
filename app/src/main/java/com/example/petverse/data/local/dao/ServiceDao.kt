package com.example.petverse.data.local.dao

import androidx.room.*
import com.example.petverse.data.local.entity.ServiceEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ServiceDao {

    @Query("SELECT * FROM services WHERE id = :serviceId")
    fun getServiceById(serviceId: String): Flow<ServiceEntity?>

    @Query("SELECT * FROM services WHERE providerUserId = :providerId ORDER BY createdAt DESC")
    fun getServicesByProviderId(providerId: String): Flow<List<ServiceEntity>>

    @Query("SELECT * FROM services WHERE category = :category ORDER BY ratingAvg DESC")
    fun getServicesByCategory(category: String): Flow<List<ServiceEntity>>

    @Query("SELECT * FROM services ORDER BY createdAt DESC")
    fun getAllServices(): Flow<List<ServiceEntity>>

    @Query("""
        SELECT * FROM services
        WHERE (:category IS NULL OR category = :category)
        AND (:minRating IS NULL OR ratingAvg >= :minRating)
        AND (:maxPrice IS NULL OR priceCents <= :maxPrice)
        ORDER BY ratingAvg DESC, priceCents ASC
    """)
    fun searchServices(
        category: String? = null,
        minRating: Double? = null,
        maxPrice: Int? = null
    ): Flow<List<ServiceEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertService(service: ServiceEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertServices(services: List<ServiceEntity>)

    @Update
    suspend fun updateService(service: ServiceEntity)

    @Delete
    suspend fun deleteService(service: ServiceEntity)

    @Query("DELETE FROM services")
    suspend fun deleteAllServices()
}