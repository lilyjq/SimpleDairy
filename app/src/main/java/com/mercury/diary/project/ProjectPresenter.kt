package com.mercury.diary.project

import com.mercury.common.base.BasePresenter
import com.mercury.common.net.ServiceUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class ProjectPresenter : BasePresenter<ProjectContract.IProjectView>(),ProjectContract.IProjectPresenter {


    override fun getProjectType() {
        bindObserver(
            ServiceUtil.getService().getProjectType().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t->
                    if(t?.data != null){
                        getView()?.getProjectTypeSuccess(t.data!!)
                    }else{
                        getView()?.getProjectTypeErr()
                    }
                }, { t -> t.printStackTrace()
                getView()?.getProjectTypeErr()})
        )
    }


}