package com.mercury.test

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mercury.diary.R
import kotlinx.android.synthetic.main.acitivty_viewmodel.*

class ViewModelTestActivity : AppCompatActivity() {



    lateinit var viewmodel :MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivty_viewmodel)
        viewmodel  = ViewModelProvider(this).get(MyViewModel::class.java)
/*
        people_s.setOnClickListener {   people_s.setText("zfzf")
            id_s.setText("10010")}*/

         if(viewmodel.people != null){
               refreshText()
         }

         people_s.setOnClickListener { setData() }
    }

    fun refreshText(){
        people_s.setText(viewmodel.people?.age + viewmodel.people?.name)
        id_s.setText(viewmodel.id)
    }

    fun setData(){
        var people = People("zs","18")
        viewmodel.people = people
        viewmodel.id =  "1001001"
        refreshText()
    }










}