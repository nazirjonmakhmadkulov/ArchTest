package com.example.archtest

import android.app.Application
import android.content.Context
import com.example.archtest.di.CoreComponent
import com.example.archtest.di.DaggerCoreComponent

class MainApp : Application(){
    lateinit var coreComponent: CoreComponent
    companion object {
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as? MainApp)?.coreComponent
    }

    override fun onCreate() {
        super.onCreate()
        initCoreDependencyInjection()
    }

    private fun initCoreDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .application(this)
            .build()
    }

}
