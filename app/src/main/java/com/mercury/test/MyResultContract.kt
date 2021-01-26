package com.mercury.test

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.text.TextUtils
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract

class MyResultContract : ActivityResultContract<String, String>() {

/*
      new activity startactivityforresult api  oneActivity twoActivity
 */
    override fun createIntent(context: Context, input: String?): Intent {
        var intent = Intent(context,TwoActivity::class.java)
        intent.putExtra("sss", input)
        return  intent

    }

    override fun parseResult(resultCode: Int, intent: Intent?): String {
        var result =  intent?.getStringExtra("result")
        if(resultCode == Activity.RESULT_OK && result != null && !TextUtils.isEmpty(result)){
            return result
        }else{
            return ""
        }

    }
}