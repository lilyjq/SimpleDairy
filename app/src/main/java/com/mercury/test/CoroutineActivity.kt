package com.mercury.test

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class CoroutineActivity : AppCompatActivity(),CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
    lateinit var job: Job


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
    }


    override fun onDestroy() {
        job.cancel()
        super.onDestroy()

    }


}