package com.example.archtest.di.modules

import android.content.Context
import androidx.room.Room
import com.example.common.Constant
import com.example.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, Constant.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
}