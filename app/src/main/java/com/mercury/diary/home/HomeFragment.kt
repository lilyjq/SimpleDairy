package com.mercury.diary.home

import android.os.Bundle
import android.view.View
import com.mercury.common.base.BaseMVPFragment

class HomeFragment  : BaseMVPFragment<HomeContract.HomeIView, HomePresenter>(),HomeContract.HomeIView{
    override fun getLayoutResId(): Int {
        TODO("Not yet implemented")
    }

    override fun initView(rootView: View?, savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun createPresent(): HomePresenter {
        TODO("Not yet implemented")
    }
}