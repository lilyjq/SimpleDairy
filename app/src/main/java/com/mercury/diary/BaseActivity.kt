package com.mercury.diary

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        initdate();
        initView();
    }


    abstract fun getLayoutRes():Int
    abstract fun initdate()
    abstract fun initView()

    protected fun start2Activity(clazz:Class<Any>){
        val intent = Intent(this,clazz)
        startActivity(intent)
    }


}