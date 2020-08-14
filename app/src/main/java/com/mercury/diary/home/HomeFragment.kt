package com.mercury.diary.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.mercury.common.base.BaseMVPFragment
import com.mercury.diary.R
import com.mercury.diary.home.bean.HomeArticleResponse
import com.mercury.diary.home.bean.HomeBannerBean
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import com.youth.banner.Banner
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.transformer.ZoomOutPageTransformer
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment  : BaseMVPFragment<HomeContract.HomeIView, HomePresenter>(),HomeContract.HomeIView,
    OnRefreshLoadMoreListener {
    var isRefreshed = false
    var isLoading = false
    lateinit var banner:Banner<HomeBannerBean,HomeBannerAdapter>
    var nowPage = 0


    lateinit var bannerAdapter:HomeBannerAdapter
    var articleAdapter:HomeArticleAdapter = HomeArticleAdapter()

    override fun getLayoutResId(): Int {
        return R.layout.fragment_home
    }

    override fun initView(rootView: View?, savedInstanceState: Bundle?) {
        banner = rootView?.findViewById(R.id.banner)!!

    }

    override fun initData() {
        super.initData()
        presenter.loadBanner()
        presenter.loadRecycler(nowPage)
        smart_refresh_layout.setOnRefreshLoadMoreListener(this)


    }

    override fun createPresent(): HomePresenter {
       return  HomePresenter()
    }


    override fun loadBannerSuccess(bannerBeans: List<HomeBannerBean>) {
        bannerAdapter = HomeBannerAdapter(bannerBeans)
            banner.setAdapter(bannerAdapter).addPageTransformer(ZoomOutPageTransformer())
                .setIndicator(CircleIndicator(context))
                .setIndicatorGravity(IndicatorConfig.Direction.CENTER)
                .setIndicatorNormalWidth(18)
                .setIndicatorSelectedWidth(18)
                .setScrollTime(800)
    }

    override fun loadBannerErr() {
        Toast.makeText(context,"loadBannerErr",Toast.LENGTH_SHORT).show()
    }


    override fun loadRecyclerSuccess(data: HomeArticleResponse) {
        articleAdapter.addList(data.dates)
        recycler.adapter = articleAdapter

    }

    override fun loadRecyclerErr() {
        Toast.makeText(context,"loadRecyclerErr",Toast.LENGTH_SHORT).show()
    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {
        nowPage++
        presenter.loadRecycler(nowPage)
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        presenter.loadRecycler(nowPage)
    }
}