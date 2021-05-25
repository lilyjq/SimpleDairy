package com.mercury.common.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        initData()
        initView()
    }


    abstract fun getLayoutRes(): Int
    abstract fun initData()
    abstract fun initView()

    protected fun start2Activity(clazz: Class<Any>) {
        val intent = Intent(this, clazz)
        startActivity(intent)
    }

    fun bundle(callback:(Bundle.() -> Unit)={}):Bundle{
        val bundle = Bundle()
        callback(bundle)
        return  bundle
    }
    inline fun <reified T:Activity> Activity.startNewActivity(bundle: Bundle = bundle()){
        var intent = Intent(this,T::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    fun tetst(){
        startNewActivity<BaseActivity>()
        startNewActivity<BaseActivity>(bundle {putString("eee","eee") })
    }


}