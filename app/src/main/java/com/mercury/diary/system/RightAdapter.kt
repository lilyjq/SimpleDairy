package com.mercury.diary.system

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mercury.diary.R
import com.mercury.diary.system.bean.SystemBean

class RightAdapter (context: Context, bean:List<SystemBean>): RecyclerView.Adapter<RightAdapter.RightViewHolder>() {

    var mContext:Context = context
    var beans: List<SystemBean> = bean

    class RightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RightViewHolder {
        var view:View = LayoutInflater.from(mContext).inflate(R.layout.item_left_recycler,parent,false)
        return  RightViewHolder(view)
    }

    override fun getItemCount(): Int {
        return beans.size

    }

    override fun onBindViewHolder(holder: RightViewHolder, position: Int) {
    }
}