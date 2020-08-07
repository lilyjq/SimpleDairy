package com.mercury.diary.main

import com.mercury.common.base.IPresenter
import com.mercury.common.base.IView

interface MainContract {

    interface  MainPresenter :IPresenter<MainIView>{

    }

    interface  MainIView : IView{

    }
}