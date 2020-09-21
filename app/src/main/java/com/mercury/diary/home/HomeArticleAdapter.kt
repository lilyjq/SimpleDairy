package com.mercury.diary.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mercury.diary.R
import com.mercury.diary.home.bean.HomeArticleBean
import com.mercury.diary.home.bean.HomeBannerBean
import com.youth.banner.Banner
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.transformer.AlphaPageTransformer
import kotlinx.android.synthetic.main.item_home_article.view.*

class HomeArticleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val TYPE_HEANDER = 0;
    val TYPE_ARITCLE = 1;

    var list: MutableList<HomeArticleBean> = mutableListOf()
    var adapter: HomeBannerAdapter? = null

    class HomeArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var timeTv: TextView? = null
        var titleTv: TextView? = null

        init {
            timeTv = itemView.findViewById(R.id.tv_time)
            titleTv = itemView.findViewById(R.id.tv_title)
        }

    }

    class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var banner: Banner<HomeBannerBean, HomeBannerAdapter>? = null

        init {
            banner = itemView.findViewById(R.id.banner)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == TYPE_HEANDER) {
            BannerViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
            )
        } else {
            HomeArticleViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_home_article, parent, false)
            )

        }


    override fun getItemViewType(position: Int): Int = if (position == 0 && adapter != null) {
        TYPE_HEANDER;
    } else {
        TYPE_ARITCLE;
    }

    override fun getItemCount(): Int = if (adapter == null) {
        list.size
    } else list.size + 1

    var isfirst = true
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TYPE_HEANDER ) {
            if(isfirst) {
                (holder as BannerViewHolder).banner?.setAdapter(adapter)
                    ?.addPageTransformer(AlphaPageTransformer())
                    ?.setIndicator(CircleIndicator(holder.banner?.context))
                    ?.setIndicatorGravity(IndicatorConfig.Direction.CENTER)
                    ?.setIndicatorNormalWidth(18)
                    ?.setIndicatorSelectedWidth(18)
                    ?.setScrollTime(800)
                isfirst = false
            }
        } else {
            var pos = position
            if(position>0 && adapter!= null ) {
                pos = position - 1
            }
            (holder as HomeArticleViewHolder).titleTv?.text = list[pos].title
             holder.timeTv?.text = list[pos].niceDate
        }
    }


     fun addList(list: List<HomeArticleBean>,isNeedClear:Boolean) {
         if(isNeedClear){
             this.list.clear()
         }
        this.list.addAll(list)
    }

     fun addBannerAdapter(adapter: HomeBannerAdapter) {
        this.adapter = adapter
    }


}