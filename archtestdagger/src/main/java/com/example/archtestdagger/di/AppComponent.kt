package com.example.archtestdagger.di

import android.app.Application
import com.example.archtestdagger.ArchTestDaggerApp
import com.example.archtestdagger.di.modules.ActivityBindingModule
import com.example.profile_dagger.di.PresentationComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBindingModule::class,
    ],
    dependencies = [PresentationComponent::class]
)
@AppScope
interface AppComponent : AndroidInjector<ArchTestDaggerApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun presentationComponent(presentationComponent: PresentationComponent): Builder
        fun build(): AppComponent
    }
}