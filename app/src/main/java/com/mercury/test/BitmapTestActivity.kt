package com.mercury.test

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.mercury.diary.R

class BitmapTestActivity :AppCompatActivity() {

    var images = arrayOf(R.drawable.diary,R.drawable.wearther_cloudy2)


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    lateinit var bitmap :Bitmap

    fun test(){
        var option:BitmapFactory.Options = BitmapFactory.Options()
        option.inMutable = true
        bitmap = BitmapFactory.decodeResource(resources,images[0],option)

    }

    fun changePic (){
        var option = BitmapFactory.Options()
        option.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources,images[1],option)
        if(canReuseBitmap(bitmap,option)){
            option.inMutable = true
            option.inBitmap = bitmap
        }
        option.inJustDecodeBounds = false;
        bitmap = BitmapFactory.decodeResource(resources,images[1],option)

    }

    fun canReuseBitmap(bitmap: Bitmap,option:BitmapFactory.Options) :Boolean{
         var targetWidth = option.outWidth/Math.max(option.inSampleSize,1)//默认argb_8888 32位 4byte
         var targetHeight = option.outHeight/Math.max(option.inSampleSize,1)
        return  targetHeight*targetWidth*4 <= bitmap.allocationByteCount
    }
}