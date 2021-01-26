package com.mercury.test

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyLifeObserver : LifecycleObserver {



    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onAtyCreate(){

    }
}