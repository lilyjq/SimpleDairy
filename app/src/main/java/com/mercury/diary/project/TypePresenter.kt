package com.mercury.diary.project

import com.mercury.common.base.BasePresenter
import com.mercury.common.net.ServiceUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class TypePresenter : BasePresenter<ProjectTypeContract.IPTypeView>(),ProjectTypeContract.IPTypePresenter{


    override fun getProjectByTypeId(page: Int, cid: Int) {
     bindObserver(ServiceUtil.getService().getProjectByTypeId(page,cid)
         .subscribeOn(Schedulers.io())
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe({
             t ->
                 if (t?.data != null) {
                     getView()?.getProjectTypeSuccess(t.data!!)
                 } else {
                     getView()?.getProjectTypeErr()
                 }
         }, { t->
             t.printStackTrace()
             getView()?.getProjectTypeErr() }))
    }
}