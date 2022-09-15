package com.example.archtest.di.modules

import com.nazaret.core.dispatcher.CoroutineDispatcherProvider
import com.nazaret.core.dispatcher.DispatcherProvider
import dagger.Binds
import dagger.Module

@Module
interface CoroutineDispatcherModule {
    @Binds
    fun bindDispatcher(dispatcherProvider: CoroutineDispatcherProvider) : DispatcherProvider
}