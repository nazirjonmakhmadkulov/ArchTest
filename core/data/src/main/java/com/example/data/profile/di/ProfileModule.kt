package com.example.data.profile.di

import com.example.common.scope.AuthUrl
import com.example.database.AppDatabase
import com.example.database.owner.dao.OwnerDao
import com.example.network.profile.data_souce.ProfileRemoteDataSource
import com.example.network.profile.remote.ProfileService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class ProfileModule {
    @Provides
    fun provideOwnerDao(db: AppDatabase): OwnerDao = db.ownerDao()

    @Provides
    fun provideProfileService(@AuthUrl retrofit: Retrofit): ProfileService =
        retrofit.create(ProfileService::class.java)

    @Provides
    fun provideProfileRemoteDataSource(profileService: ProfileService) =
        ProfileRemoteDataSource(profileService)
}