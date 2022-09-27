package com.example.data_dagger.di.modules

import com.example.network.profile.data_souce.ProfileRemoteDataSource
import com.example.network.profile.remote.ProfileService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ProfileModule {
    @Provides
    fun provideProfileService(retrofit: Retrofit): ProfileService =
        retrofit.create(ProfileService::class.java)

    @Provides
    fun provideProfileRemoteDataSource(profileService: ProfileService) =
        ProfileRemoteDataSource(profileService)
}