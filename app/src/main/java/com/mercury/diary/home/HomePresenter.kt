package com.mercury.diary.home

import com.mercury.common.base.BasePresenter
import com.mercury.common.base.BaseResponse
import com.mercury.common.net.ServiceUtil
import com.mercury.diary.home.bean.HomeBannerBean
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class HomePresenter : BasePresenter<HomeContract.HomeIView>(), HomeContract.IHomePresenter {


    override fun loadBanner() {
        bindObserver(ServiceUtil.getService().getBanner()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t ->
                if (t.data == null) {
                    getView()?.loadBannerErr()
                } else {
                    getView()?.loadBannerSuccess(t.data!!)
                }
            }, { t ->
                t.printStackTrace()
                getView()?.loadBannerErr()
            })
        )
    }

    override fun loadRecycler(page: Int) {
        bindObserver(ServiceUtil.getService().getHomePageArticle(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t ->
                if (t.data != null && t.errorCode == 0) {
                    getView()?.loadRecyclerSuccess(t.data!!)
                } else {
                    getView()?.loadRecyclerErr()
                }
            }, { t ->
                t.printStackTrace()
                getView()?.loadRecyclerErr()
            })
        )

    }
}