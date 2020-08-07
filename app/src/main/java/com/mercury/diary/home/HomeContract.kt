package com.mercury.diary.home

import com.mercury.common.base.IPresenter
import com.mercury.common.base.IView

interface HomeContract {
    interface HomeIView :IView{

    }

    interface HomePresenter : IPresenter<HomeIView>{

    }
}