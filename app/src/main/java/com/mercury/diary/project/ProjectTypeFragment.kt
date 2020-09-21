package com.mercury.diary.project

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mercury.common.base.BaseFragment
import com.mercury.common.base.BaseMVPFragment
import com.mercury.diary.R
import com.mercury.diary.home.HomeArticleAdapter
import com.mercury.diary.home.bean.HomeArticleResponse
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.fragment_project_type.*

class ProjectTypeFragment (cid:Int): BaseMVPFragment<ProjectTypeContract.IPTypeView,TypePresenter>(),ProjectTypeContract.IPTypeView,
    OnRefreshLoadMoreListener {

    var nowPage:Int = 1
    var cid: Int =294
    init {
        this.cid = cid
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_project_type
    }

    var adapter:HomeArticleAdapter? = null
    override fun initView(rootView: View?, savedInstanceState: Bundle?) {
        refresh_layout.setOnRefreshLoadMoreListener(this)
        recycler.layoutManager= LinearLayoutManager(context)
        adapter= HomeArticleAdapter()
        recycler.adapter = adapter
        presenter.getProjectByTypeId(nowPage,cid)
    }

    override fun getProjectTypeSuccess(result: HomeArticleResponse) {
        var isFirstPage = (nowPage == 1)

        adapter?.addList(result.datas,isFirstPage)
        adapter?.notifyDataSetChanged()
    }

    override fun getProjectTypeErr() {
       Toast.makeText(context,"getProjectTypeErr",Toast.LENGTH_SHORT).show()
    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {
        nowPage++
        presenter.getProjectByTypeId(nowPage,cid)
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        nowPage = 1
        presenter.getProjectByTypeId(nowPage,cid)
    }

    override fun createPresent(): TypePresenter {
       return  TypePresenter()
    }
}