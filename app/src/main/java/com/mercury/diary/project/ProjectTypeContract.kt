package com.mercury.diary.project

import com.mercury.common.base.IPresenter
import com.mercury.common.base.IView
import com.mercury.diary.home.bean.HomeArticleResponse

interface ProjectTypeContract {

    interface  IPTypeView : IView{
        fun getProjectTypeSuccess(result: HomeArticleResponse)
        fun getProjectTypeErr()

    }

    interface IPTypePresenter: IPresenter<IPTypeView>{
       fun getProjectByTypeId(page:Int,cid:Int)
    }


}