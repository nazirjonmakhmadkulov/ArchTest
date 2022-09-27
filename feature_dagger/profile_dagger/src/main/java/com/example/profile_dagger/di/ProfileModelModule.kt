package com.example.profile_dagger.di

import androidx.lifecycle.ViewModel
import com.example.profile_dagger.ProfileDaggerViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProfileDaggerViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ProfileDaggerViewModel::class)
    internal abstract fun profileDaggerViewModel(viewModel: ProfileDaggerViewModel): ViewModel
}