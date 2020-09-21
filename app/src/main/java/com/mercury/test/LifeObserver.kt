package com.mercury.test

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class LifeObserver : LifecycleObserver{

     @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
     fun create(){

     }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start(){

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume(){

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause(){

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop(){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy(){

    }


}