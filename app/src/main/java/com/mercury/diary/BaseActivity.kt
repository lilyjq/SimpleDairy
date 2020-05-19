package com.mercury.diary

import android.app.Activity
import android.content.Intent
import android.os.Bundle

abstract class BaseActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
    }


    abstract fun getLayoutRes():Int
    abstract fun initdate()
    abstract fun initView()

    protected fun startActivity(clazz:java){
        val intent = Intent(this,clazz)
        startActivity(intent)
    }


}