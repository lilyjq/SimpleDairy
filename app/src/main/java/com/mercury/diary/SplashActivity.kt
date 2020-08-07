package com.mercury.diary

import android.app.Activity
import android.os.Bundle
import android.util.Log

class SplashActivity :Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_diary)
        Log.e("S:","              oncreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e("S:","              onStart")
    }


    override fun onResume() {
        super.onResume()
        Log.e("S:","              onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("S:","              onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("S:","              onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("S:","              onDestroy")
    }
}