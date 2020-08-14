package com.mercury.diary.home

import com.mercury.common.base.IPresenter
import com.mercury.common.base.IView
import com.mercury.diary.home.bean.HomeArticleResponse
import com.mercury.diary.home.bean.HomeBannerBean

interface HomeContract {
    interface HomeIView :IView{
        fun loadBannerSuccess(bannerBeans: List<HomeBannerBean>)

        fun loadBannerErr()
        fun loadRecyclerSuccess(data:HomeArticleResponse)
        fun loadRecyclerErr()



    }

    interface IHomePresenter : IPresenter<HomeIView>{
           fun loadBanner()
          fun loadRecycler(page:Int)

    }
}