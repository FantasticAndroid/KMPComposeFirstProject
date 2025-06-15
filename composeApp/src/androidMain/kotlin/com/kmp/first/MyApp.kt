package com.kmp.first

import android.app.Application
import di.initKoin
import org.koin.android.ext.koin.androidContext

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin{
            androidContext(this@MyApp)
        }
    }
}