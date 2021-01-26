package com.mercury.diary.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mercury.diary.R
import com.mercury.diary.home.HomeArticleAdapter
import com.mercury.diary.home.bean.HomeArticleBean

class ProjectAdapterPaging : PagedListAdapter<HomeArticleBean, ProjectAdapterPaging.ViewHolder>(DIFF_CALLBACK) {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var timeTv: TextView? = null
        var titleTv: TextView? = null
        var item:HomeArticleBean?= null

        init {
            timeTv = itemView.findViewById(R.id.tv_time)
            titleTv = itemView.findViewById(R.id.tv_title)
        }

        fun bindTo(item:HomeArticleBean){
            this.item = item;
            titleTv?.text = item.title
            timeTv?.text = item.niceDate
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(  LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_article, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bindTo()
    }

    companion object {
        val DIFF_CALLBACK  = object :DiffUtil.ItemCallback<HomeArticleBean>() {
            override fun areItemsTheSame(
                oldItem: HomeArticleBean,
                newItem: HomeArticleBean
            ): Boolean = oldItem.id == newItem.id


            override fun areContentsTheSame(
                oldItem: HomeArticleBean,
                newItem: HomeArticleBean
            ): Boolean = oldItem == newItem
        }
    }
}
