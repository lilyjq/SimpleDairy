package com.mercury.test

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mercury.diary.R
import kotlinx.android.synthetic.main.activity_two.*

class TwoActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        tv_top.text = intent.getStringExtra("sss")


        tv_back.setOnClickListener(View.OnClickListener { var intent = Intent().apply { putExtra("result","i have an apple i have a pen !") }
        setResult(Activity.RESULT_OK,intent)
            finish()
        })
    }




}