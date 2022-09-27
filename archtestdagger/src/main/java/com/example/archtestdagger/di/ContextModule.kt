package com.example.archtestdagger.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule {
    @Provides
    fun provideContext(app: Application): Context = app
}