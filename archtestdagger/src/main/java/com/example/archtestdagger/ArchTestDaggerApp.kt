package com.example.archtestdagger

import android.app.Application
import com.example.archtestdagger.di.DaggerAppComponent
import com.example.data_dagger.di.DaggerProfileDomainComponent
import com.example.data_dagger.di.ProfileDomainComponent
import com.example.profile_dagger.di.DaggerPresentationComponent
import com.example.profile_dagger.di.PresentationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class ArchTestDaggerApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        val appComponent = DaggerAppComponent.builder().application(this)
            .presentationComponent(providePresentationComponent()).build()
        appComponent.inject(this)
    }

    private fun providePresentationComponent(): PresentationComponent {
        return DaggerPresentationComponent.builder().domainComponent(provideDomainComponent())
            .build()
    }

    private fun provideDomainComponent(): ProfileDomainComponent {
        return DaggerProfileDomainComponent.builder().build()
    }
}