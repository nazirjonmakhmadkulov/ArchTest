package com.example.archtestdagger.di

import android.app.Application
import com.example.archtestdagger.ArchTestDaggerApp
import com.example.archtestdagger.di.modules.ActivityBindingModule
import com.example.common.dispatcher.DispatcherProvider
import com.example.common.scope.SocialUrl
import com.example.profile_dagger.di.PresentationComponent
import com.example.profile_dagger.di.ProfileDaggerViewModelModule
import com.example.profile_dagger.di.ScreenBindingModule
import com.example.profile_dagger.di.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import retrofit2.Retrofit

@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class,
        CoroutineDispatcherModule::class,
        ViewModelModule::class,
        AndroidInjectionModule::class,
        ActivityBindingModule::class,
        ScreenBindingModule::class,
        ProfileDaggerViewModelModule::class,
    ],
    dependencies = [PresentationComponent::class]
)
@AppScope
interface AppComponent : AndroidInjector<ArchTestDaggerApp> {
    @SocialUrl
    fun retrofitSocial(): Retrofit
    fun dispatcher(): DispatcherProvider

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun presentationComponent(presentationComponent: PresentationComponent): Builder
        fun build(): AppComponent
    }
}