package com.mercury.diary.main

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.mercury.common.base.BaseMVPActivity
import com.mercury.diary.R
import com.mercury.test.LifeObserver
import com.mercury.test.OneActivity
import com.mercury.test.VLActivity
import com.mercury.test.ViewModelTestActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Logger


class MainActivity : BaseMVPActivity<MainContract.MainIView,MainPresenter>() {



    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }


    override fun initView() {
        design_navigation_view.setNavigationItemSelectedListener { item: MenuItem ->
          hideNavigation()
          when(item.itemId){
              R.id.item1 -> {
                  Toast.makeText(this, "R.id.item1", Toast.LENGTH_SHORT).show()
              }

              R.id.item2 ->{
                  Toast.makeText(this, "R.id.item2", Toast.LENGTH_SHORT).show()
              }

              R.id.item3 ->{
                  Toast.makeText(this, "R.id.item3", Toast.LENGTH_SHORT).show()
              }

              R.id.item4 ->{
                  Toast.makeText(this, "R.id.item4", Toast.LENGTH_SHORT).show()
              }

          }
            true

          }


        lifecycle.addObserver(LifeObserver())
        findViewById<TextView>(R.id.tv_top).apply {
//            text = viewMo
        }
//
//        val intArray = IntArray(5){ it*2 + 1 }
//
//        intArray.forEach({
//            it -> Log.e("eee",it.toString())
//        })
//        val intent = Intent(this, VLActivity::class.java)
//        startActivity(intent)

        val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
        val twoParameters: (String, Int) -> String = repeatFun // OK

        fun runTransformation(f: (String, Int) -> String): String {
            return f("hello", 3)
        }
        val result = runTransformation(repeatFun) // OK

        Log.e("eee",result)

        }



    fun hideNavigation(){
        drawlayout.closeDrawer(Gravity.LEFT)
        var bitmap:Bitmap;
//        bitmap.compress(Bitmap.CompressFormat.JPEG,8,)
        var option= BitmapFactory.Options()


    }


    fun showNavigation(){
        drawlayout.openDrawer(Gravity.LEFT)
    }

    override fun createPresent(): MainPresenter {
        return  MainPresenter()
    }

}





