package com.example.archtest.di

import android.app.Application
import android.content.Context
import com.example.archtest.di.modules.*
import com.example.archtest.di.scope.AuthUrl
import com.example.database.AppDatabase
import com.nazaret.core.dispatcher.DispatcherProvider
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        SharedPreferenceModule::class,
        CoroutineDispatcherModule::class,
    ]
)
interface CoreComponent {
    fun context(): Context
//    fun sharedPreference(): SharedPreference
    fun appDatabase(): AppDatabase

    @AuthUrl
    fun retrofitAuth(): Retrofit
    fun dispatcher(): DispatcherProvider

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): CoreComponent
    }
}