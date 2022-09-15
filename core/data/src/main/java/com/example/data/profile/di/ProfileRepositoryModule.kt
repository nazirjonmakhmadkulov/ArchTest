package com.example.data.profile.di


import com.example.data.profile.repository.ProfileRepository
import com.example.data.profile.repository.ProfileRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface ProfileRepositoryModule {
    @Binds
    fun bindProfileRepository(repository: ProfileRepositoryImpl): ProfileRepository
}