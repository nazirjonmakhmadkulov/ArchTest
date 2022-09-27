package com.example.data_dagger.di.usecases

import com.example.data_dagger.di.repository.ProfileRepository
import javax.inject.Inject

class ProfileUseCase @Inject constructor(private val profileRepository: ProfileRepository) {
    suspend fun invokeGetMe() = profileRepository.getMe()
    suspend fun invokeGetUser(userId: String) = profileRepository.getUser(userId)
   // fun getLocalOwner(id: String) = profileRepository.getLocalOwner(id)
}