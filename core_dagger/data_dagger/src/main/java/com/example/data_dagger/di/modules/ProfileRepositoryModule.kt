package com.example.data_dagger.di.modules


import com.example.data_dagger.di.repository.ProfileRepository
import com.example.data_dagger.di.repository.ProfileRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface ProfileRepositoryModule {
    @Binds
    fun bindProfileRepository(repository: ProfileRepositoryImpl): ProfileRepository
}