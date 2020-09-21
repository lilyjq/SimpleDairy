package com.mercury.diary.system

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mercury.diary.R
import com.mercury.diary.system.bean.SystemBean

class LeftAdapter (context: Context,bean:List<SystemBean>): RecyclerView.Adapter<LeftAdapter.LeftViewHolder>() {



     var mContext:Context = context
     var beans: List<SystemBean> = bean


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeftViewHolder {
        var view :View = LayoutInflater.from(mContext).inflate(R.layout.item_left_recycler,parent,false)
        return  LeftViewHolder(view)
    }

    override fun getItemCount(): Int {
      return  beans.size
    }

    override fun onBindViewHolder(holder: LeftViewHolder, position: Int) {
           holder.textView.text = beans[position].name
    }


    class LeftViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
              var textView:TextView = itemView.findViewById(R.id.tv_top)
    }
}