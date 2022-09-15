package com.example.data.profile.usecases

import com.example.data.profile.repository.ProfileRepository
import javax.inject.Inject

class ProfileUseCase @Inject constructor(private val profileRepository: ProfileRepository) {
    suspend fun invokeGetMe() = profileRepository.getMe()
    suspend fun invokeGetUser(userId: String) = profileRepository.getUser(userId)
    fun getLocalOwner(id: String) = profileRepository.getLocalOwner(id)
}