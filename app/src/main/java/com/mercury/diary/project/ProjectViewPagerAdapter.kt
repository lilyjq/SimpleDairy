package com.mercury.diary.project

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.mercury.diary.project.bean.ProjectTypeBean
import java.util.logging.Logger

class ProjectViewPagerAdapter(fm: FragmentManager,beans: List<ProjectTypeBean>) : FragmentPagerAdapter(fm) {


    var list: List<ProjectTypeBean> = beans
    var fragments: MutableList<ProjectTypeFragment> = mutableListOf()

    init {
        for (i in list.indices) {
            Log.e("eeeee", i.toString() + "          " + list[i].id)
            fragments.add(ProjectTypeFragment(list[i].id))
        }
    }


    override fun getItem(position: Int): Fragment {
        Log.e("eeeee" + position, fragments[position].toString())
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list[position].name
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return super.instantiateItem(container, position)
    }

}