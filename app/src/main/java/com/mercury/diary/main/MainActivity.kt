package com.mercury.diary.main

import com.mercury.common.base.BaseMVPActivity
import com.mercury.diary.R


abstract  class MainActivity : BaseMVPActivity<MainContract.MainIView,MainPresenter>() {



    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }


    override fun initView() {

    }


}
