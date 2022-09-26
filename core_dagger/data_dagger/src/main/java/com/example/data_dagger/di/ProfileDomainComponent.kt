package com.example.data_dagger.di

import com.example.data_dagger.di.modules.ProfileModule
import com.example.data_dagger.di.modules.ProfileRepositoryModule
import dagger.Component

@Component(
    modules = [ProfileModule::class, ProfileRepositoryModule::class]
)
@DomainScope
interface ProfileDomainComponent {
    @Component.Builder
    interface Builder {
        fun build(): ProfileDomainComponent
    }
}