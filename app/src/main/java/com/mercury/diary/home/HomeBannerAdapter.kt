package com.mercury.diary.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mercury.diary.R
import com.mercury.diary.home.bean.HomeBannerBean
import com.youth.banner.adapter.BannerAdapter

class HomeBannerAdapter(datas: List<HomeBannerBean>) :
    BannerAdapter<HomeBannerBean, HomeBannerAdapter.BannerViewHolder>(datas) {

       var context:Context? = null


    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): BannerViewHolder {
        context = parent?.context
        var view:View = LayoutInflater.from(parent?.context).inflate(R.layout.item_banner,parent)
        return BannerViewHolder(view)
    }

    override fun onBindView(
        holder: BannerViewHolder?,
        data: HomeBannerBean?,
        position: Int,
        size: Int
    ) {

        if(holder?.bannerIv != null) {
            Glide.with(context!!).load(data?.imagePath).apply(RequestOptions().centerCrop())
                .into(holder.bannerIv!!)
        }
        holder?.bannerTv?.text = data?.title

    }


    class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var bannerTv:TextView? = null
        var bannerIv:ImageView? = null
        init {
                bannerTv= itemView.findViewById(R.id.tv_banner)
                bannerIv = itemView.findViewById(R.id.iv_banner)
           }
    }

}