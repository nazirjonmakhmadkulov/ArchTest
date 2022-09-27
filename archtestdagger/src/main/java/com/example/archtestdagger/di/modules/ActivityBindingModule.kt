package com.example.archtestdagger.di.modules

import com.example.archtestdagger.MainActivity
import com.example.data_dagger.di.modules.ProfileModule
import com.example.data_dagger.di.modules.ProfileRepositoryModule
import com.example.profile_dagger.ProfileDaggerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}