package com.mercury.diary.project

import com.mercury.common.base.IPresenter
import com.mercury.common.base.IView
import com.mercury.diary.project.bean.ProjectTypeBean

interface ProjectContract {
    interface IProjectView:IView{
        fun getProjectTypeSuccess(beans:List<ProjectTypeBean>)
        fun getProjectTypeErr()

    }

    interface IProjectPresenter :IPresenter<IProjectView>{
        fun getProjectType()
    }
}