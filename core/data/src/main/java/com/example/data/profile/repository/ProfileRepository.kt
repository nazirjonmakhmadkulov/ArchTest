package com.example.data.profile.repository

import com.example.common.network.Result
import com.example.database.owner.entities.OwnerEntity
import com.example.model.Profile
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.flow.Flow


interface ProfileRepository {
    suspend fun getMe(): Result<Profile.Data>
    suspend fun getUser(userId: String): Result<Profile.Data>
    fun getLocalOwner(id: String): Flow<Profile.Data?>
}