package com.mercury.diary.main

import android.view.MenuItem
import com.mercury.common.base.BaseMVPActivity
import com.mercury.diary.R
import kotlinx.android.synthetic.main.activity_main.*


abstract  class MainActivity : BaseMVPActivity<MainContract.MainIView,MainPresenter>() {



    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }


    override fun initView() {
    /*    design_navigation_view.setNavigationItemSelectedListener { item: MenuItem ->



        }*/

    }




}
