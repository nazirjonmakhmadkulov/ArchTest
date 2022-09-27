package com.example.data_dagger.di.repository

import com.example.common.network.Result
import com.example.model.Profile
import kotlinx.coroutines.flow.Flow


interface ProfileRepository {
    suspend fun getMe(): Result<Profile.Data>
    suspend fun getUser(userId: String): Result<Profile.Data>
    //fun getLocalOwner(id: String): Flow<Profile.Data?>
}