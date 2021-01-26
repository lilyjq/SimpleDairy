package com.mercury.diary.project

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import com.mercury.common.base.BaseMVPActivity
import com.mercury.common.base.BaseMVPFragment
import com.mercury.diary.R
import com.mercury.diary.project.bean.ProjectTypeBean
import kotlinx.android.synthetic.main.fragment_project.*

class ProjectFragment : BaseMVPFragment<ProjectContract.IProjectView, ProjectPresenter>(),
    ProjectContract.IProjectView {

    override fun createPresent(): ProjectPresenter {
        return ProjectPresenter()
    }




    override fun getLayoutResId(): Int {
        return R.layout.fragment_project
    }

    override fun initView(rootView: View?, savedInstanceState: Bundle?) {
        presenter.getProjectType()
    }

    override fun getProjectTypeSuccess(beans: List<ProjectTypeBean>) {
        view_pager.adapter = ProjectViewPagerAdapter(childFragmentManager, beans)
        tablayout.setupWithViewPager(view_pager)


    }

    override fun getProjectTypeErr() {
        Toast.makeText(context,"getProjectTypeErr",Toast.LENGTH_SHORT).show()
    }
}