package com.example.database.owner.dao

import androidx.room.*
import com.example.database.owner.entities.OwnerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OwnerDao {
    @Query("SELECT * FROM owner")
    fun getAllUsers(): Flow<List<OwnerEntity>>

    @Query("SELECT * FROM owner WHERE id = :id")
    fun getUserById(id: String): Flow<OwnerEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(ownerEntity: OwnerEntity)

    @Update
    suspend fun updateUser(ownerEntity: OwnerEntity)

    @Delete
    suspend fun deleteUser(ownerEntity: OwnerEntity)
}