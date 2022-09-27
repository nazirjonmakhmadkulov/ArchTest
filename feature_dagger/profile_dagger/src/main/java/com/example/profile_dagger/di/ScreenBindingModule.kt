package com.example.profile_dagger.di

import com.example.data_dagger.di.modules.ProfileModule
import com.example.data_dagger.di.modules.ProfileRepositoryModule
import com.example.profile_dagger.ProfileDaggerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ProfileModule::class, ProfileRepositoryModule::class])
abstract class ScreenBindingModule {
    @ContributesAndroidInjector
    abstract fun profileDaggerFragment(): ProfileDaggerFragment
}