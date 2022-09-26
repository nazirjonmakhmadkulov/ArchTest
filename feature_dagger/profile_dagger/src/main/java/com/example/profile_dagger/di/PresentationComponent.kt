package com.example.profile_dagger.di

import com.example.data_dagger.di.ProfileDomainComponent
import dagger.Component

@Component(
    dependencies = [ProfileDomainComponent::class]
)
@PresentationScope
interface PresentationComponent {

    @Component.Builder
    interface Builder {
        fun domainComponent(domainComponent: ProfileDomainComponent): Builder
        fun build(): PresentationComponent
    }
}