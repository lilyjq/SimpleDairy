package com.mercury.diary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainDiaryAdapter(context: Context): RecyclerView.Adapter<MainDiaryAdapter.MainDiaryViewHolder>() {

    init {

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainDiaryViewHolder {
          var view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_diary,parent,false);
          return MainDiaryViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MainDiaryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class MainDiaryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTv:TextView?= null
        var contentTv:TextView?= null
        init {
            titleTv = itemView.findViewById(R.id.tv_title)
            contentTv = itemView.findViewById(R.id.tv_content)
        }
    }
}