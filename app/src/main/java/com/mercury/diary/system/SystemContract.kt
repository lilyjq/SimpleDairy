package com.mercury.diary.system

import com.mercury.common.base.IPresenter
import com.mercury.common.base.IView
import com.mercury.diary.system.bean.SystemBean

interface SystemContract {

    interface ISystemView : IView {
        fun getSystemSuccess(bean: List<SystemBean>)
        fun getSystemErr()

    }

    interface ISystemPresenter : IPresenter<ISystemView> {
        fun getSystem();
        fun getSecondSystem(page: Int, cid: Int);
    }

}