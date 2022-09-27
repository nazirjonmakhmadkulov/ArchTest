package com.example.archtestdagger.di

import com.example.common.dispatcher.CoroutineDispatcherProvider
import com.example.common.dispatcher.DispatcherProvider
import dagger.Binds
import dagger.Module

@Module
interface CoroutineDispatcherModule {
    @Binds
    fun bindDispatcher(dispatcherProvider: CoroutineDispatcherProvider) : DispatcherProvider
}