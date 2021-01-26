package com.mercury.test

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mercury.diary.R
import com.mercury.diary.databinding.ActivityLifeBinding

//import com.mercury.diary.databinding.ActivityLifeBinding


//databinding

class LifeActivity : Activity() {

    private lateinit var mBinding : ActivityLifeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val binding :
        //1
//        mBinding =  DataBindingUtil.setContentView(this, R.layout.activity_life)
        //2
        mBinding =  ActivityLifeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.user = People("addd","23333")
//        mBinding = ActivityLifeBinding.inflate(layoutInflater)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    suspend fun getResult(){

    }

}