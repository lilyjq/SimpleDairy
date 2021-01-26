package com.mercury.common.base

import android.app.Application
import androidx.multidex.MultiDex

class MyApplication : Application() {

    lateinit var app:MyApplication
    override fun onCreate() {
        super.onCreate()
        app = this
        MultiDex.install(app)
    }
}