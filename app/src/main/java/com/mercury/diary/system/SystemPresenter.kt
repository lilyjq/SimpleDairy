package com.mercury.diary.system

import com.mercury.common.base.BasePresenter
import com.mercury.common.net.NetUtil
import com.mercury.common.net.ServiceUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class SystemPresenter : BasePresenter<SystemContract.ISystemView>(),SystemContract.ISystemPresenter {



    override fun getSystem() {
        bindObserver(ServiceUtil.getService().getSystem().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t->
                if(t.data != null  && t.errorCode != 0){
                   getView()?.getSystemSuccess(t.data!!)
                }else{
                   getView()?.getSystemErr()
                }
            }, { t -> t.printStackTrace()
                getView()?.getSystemErr()
            }))
    }

    override fun getSecondSystem(page: Int, cid: Int) {
        bindObserver(ServiceUtil.getService().getSecondSystem(page,cid).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer { t -> if(t.data != null && t.errorCode != 0){

            }else{

            } }))
    }

}