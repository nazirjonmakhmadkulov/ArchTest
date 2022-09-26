package com.example.data.profile.di


import com.example.data.profile.repository.ProfileRepository
import com.example.data.profile.repository.ProfileRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface ProfileRepositoryModule {
    @Binds
    fun bindProfileRepository(repository: ProfileRepositoryImpl): ProfileRepository
}