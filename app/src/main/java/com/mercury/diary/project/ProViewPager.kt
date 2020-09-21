package com.mercury.diary.project

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class ProViewPager(context: Context, attrs: AttributeSet?) : ViewPager(context, attrs) {
    private var downX :Float = 0f

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        when(ev?.action){
            MotionEvent.ACTION_DOWN ->{
                downX = ev.x
                parent.requestDisallowInterceptTouchEvent(true)
                return super.dispatchTouchEvent(ev)
            }

            MotionEvent.ACTION_MOVE ->{
                val movX :Float = ev.x
                val currentItem :Int = currentItem
                val deltaX:Float = movX- downX
                if(currentItem == 0 && deltaX>0){
                    parent.requestDisallowInterceptTouchEvent(false)
                }else if((currentItem == adapter!!.count-1)&& deltaX <0 ){
                    parent.requestDisallowInterceptTouchEvent(false)
                }else{
                    parent.requestDisallowInterceptTouchEvent(true)
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }



}