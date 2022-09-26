package com.example.profile_dagger.di

import androidx.lifecycle.ViewModelProvider
import com.example.profile_dagger.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}