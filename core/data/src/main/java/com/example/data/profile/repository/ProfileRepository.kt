package com.example.data.profile.repository

import com.example.common.network.Result
import com.example.database.owner.entities.OwnerEntity
import com.example.model.Profile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    suspend fun getMe(): Result<Profile.Data>
    suspend fun getUser(userId: String): Result<Profile.Data>
    fun getLocalOwner(id: String): Flow<OwnerEntity?>
}