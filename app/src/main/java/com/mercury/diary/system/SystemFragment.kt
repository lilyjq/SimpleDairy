package com.mercury.diary.system

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.mercury.common.base.BaseMVPFragment
import com.mercury.diary.R
import com.mercury.diary.system.bean.SystemBean
import kotlinx.android.synthetic.main.fragment_system.*

class SystemFragment : BaseMVPFragment<SystemContract.ISystemView, SystemPresenter>(),SystemContract.ISystemView {
    override fun createPresent(): SystemPresenter {
       return  SystemPresenter()
    }

    override fun getLayoutResId(): Int {
        return  R.layout.fragment_system
    }

    override fun initView(rootView: View?, savedInstanceState: Bundle?) {
         presenter.getSystem()
         leftRecycler.layoutManager = LinearLayoutManager(context)
         rightRecycler.layoutManager = LinearLayoutManager(context)

    }





    override fun getSystemSuccess(bean: List<SystemBean>) {
        leftRecycler.adapter = context?.let { LeftAdapter(it,bean) }

    }

    override fun getSystemErr() {
    }
}