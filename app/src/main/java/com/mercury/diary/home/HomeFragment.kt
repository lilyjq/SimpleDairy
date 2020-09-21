package com.mercury.diary.home

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mercury.common.base.BaseMVPFragment
import com.mercury.diary.R
import com.mercury.diary.home.bean.HomeArticleResponse
import com.mercury.diary.home.bean.HomeBannerBean
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import com.youth.banner.Banner
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.transformer.AlphaPageTransformer
import com.youth.banner.transformer.ZoomOutPageTransformer
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment (): BaseMVPFragment<HomeContract.HomeIView, HomePresenter>(),HomeContract.HomeIView,
    OnRefreshLoadMoreListener {
    var isRefreshed = false
    var isLoading = false
    var nowPage = 0


    lateinit var bannerAdapter:HomeBannerAdapter
    var articleAdapter:HomeArticleAdapter = HomeArticleAdapter()

    override fun getLayoutResId(): Int {
        return R.layout.fragment_home
    }

    override fun initView(rootView: View?, savedInstanceState: Bundle?) {
        presenter.loadBanner()
        presenter.loadRecycler(nowPage)
        smart_refresh_layout.setOnRefreshLoadMoreListener(this)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = articleAdapter

    }

    override fun initData() {
        super.initData()


        /**let 使用it 去访问其公共方法
        presenter.let {
            it.loadRecycler()
        }
        let 判空 如果不是null的执行{} 操作
        presenter?.let {  }
        **/

    }

    override fun createPresent(): HomePresenter {
       return  HomePresenter()
    }


    override fun loadBannerSuccess(bannerBeans: List<HomeBannerBean>) {
        bannerAdapter = HomeBannerAdapter(bannerBeans)
        articleAdapter.adapter =bannerAdapter
//            banner.setAdapter(bannerAdapter).addPageTransformer(AlphaPageTransformer())
//                .setIndicator(CircleIndicator(context))
//                .setIndicatorGravity(IndicatorConfig.Direction.CENTER)
//                .setIndicatorNormalWidth(18)
//                .setIndicatorSelectedWidth(18)
//                .setScrollTime(800)
    }

    override fun loadBannerErr() {
        Toast.makeText(context,"loadBannerErr",Toast.LENGTH_SHORT).show()
    }


    override fun loadRecyclerSuccess(data: HomeArticleResponse) {
        var isFirstPage = (nowPage == 0)
        articleAdapter.addList(data.datas,isFirstPage)
        articleAdapter.notifyDataSetChanged()

    }

    override fun loadRecyclerErr() {
        Toast.makeText(context,"loadRecyclerErr",Toast.LENGTH_SHORT).show()
    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {
        nowPage++
        presenter.loadRecycler(nowPage)
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        nowPage = 0
        presenter.loadRecycler(nowPage)
    }
}