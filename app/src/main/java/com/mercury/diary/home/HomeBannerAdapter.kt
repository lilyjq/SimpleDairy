package com.mercury.diary.home

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.youth.banner.adapter.BannerAdapter

class HomeBannerAdapter(datas: MutableList<HomeBannerBean>?) :
    BannerAdapter<HomeBannerBean, HomeBannerAdapter.BannerViewHolder>(datas) {








    class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): BannerViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindView(
        holder: BannerViewHolder?,
        data: HomeBannerBean?,
        position: Int,
        size: Int
    ) {
        TODO("Not yet implemented")
    }


}