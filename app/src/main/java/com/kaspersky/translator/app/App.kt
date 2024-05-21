package com.kaspersky.translator.app

import android.app.Application
import com.kaspersky.translator.di.AppComponent
import com.kaspersky.translator.di.AppModule
import com.kaspersky.translator.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()

    }
}