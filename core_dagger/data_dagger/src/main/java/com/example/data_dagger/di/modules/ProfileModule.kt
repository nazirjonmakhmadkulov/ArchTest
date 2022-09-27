package com.example.data_dagger.di.modules

import com.example.common.scope.SocialUrl
import com.example.network_dagger.data_souce.ProfileRemoteDataSource
import com.example.network_dagger.remote.ProfileService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ProfileModule {
//    @Provides
//    fun provideOwnerDao(db: AppDatabase): OwnerDao = db.ownerDao()

    @Provides
    fun provideProfileService(@SocialUrl retrofit: Retrofit): ProfileService =
        retrofit.create(ProfileService::class.java)

    @Provides
    fun provideProfileRemoteDataSource(profileService: ProfileService) =
        ProfileRemoteDataSource(profileService)
}