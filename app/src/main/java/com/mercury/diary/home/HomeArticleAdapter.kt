package com.mercury.diary.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mercury.diary.R
import com.mercury.diary.home.bean.HomeArticleBean
import kotlinx.android.synthetic.main.item_home_article.view.*

class HomeArticleAdapter : RecyclerView.Adapter<HomeArticleAdapter.HomeArticleViewHolder>() {

     var list: MutableList<HomeArticleBean> =  mutableListOf()

    class HomeArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var timeTv:TextView? = null
        var titleTv:TextView? = null
        init {
            timeTv = itemView.findViewById(R.id.tv_time)
            titleTv = itemView.findViewById(R.id.tv_title)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeArticleViewHolder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_home_article,parent,false)
        return HomeArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: HomeArticleViewHolder, position: Int) {
        holder.titleTv?.text = list[position].title
        holder.timeTv?.text = list[position].niceDate
    }

    public fun addList(list: List<HomeArticleBean>){
            this.list.addAll(list)
    }
}