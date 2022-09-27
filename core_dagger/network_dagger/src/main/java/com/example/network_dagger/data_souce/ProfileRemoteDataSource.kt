package com.example.network_dagger.data_souce

import com.example.common.network.RemoteDataSource
import com.example.network_dagger.model.RemoteProfile
import com.example.network_dagger.remote.ProfileService
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ProfileRemoteDataSource @Inject constructor(private val profileService: ProfileService) :
    RemoteDataSource() {
    suspend fun getOwner(dispatcher: CoroutineDispatcher): com.example.common.network.Result<RemoteProfile.Data> {
        return safeApiCall(dispatcher) { profileService.getOwner() }
    }

    suspend fun getMe(dispatcher: CoroutineDispatcher): com.example.common.network.Result<RemoteProfile.Data> {
        return safeApiCall(dispatcher) { profileService.getMe() }
    }

    suspend fun getUser(
        dispatcher: CoroutineDispatcher, userId: String
    ): com.example.common.network.Result<RemoteProfile.Data> {
        return safeApiCall(dispatcher) { profileService.getUser(userId) }
    }
}