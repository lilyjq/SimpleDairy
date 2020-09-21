package com.mercury.test

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mercury.diary.R
import com.mercury.diary.databinding.ActivityTestBinding

class TextActivity : Activity() {

 lateinit var mBinding:ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test)
        mBinding = ActivityTestBinding.inflate(layoutInflater)
    }
}