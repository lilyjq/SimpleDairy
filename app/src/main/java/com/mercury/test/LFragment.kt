package com.mercury.test

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mercury.diary.R
import kotlinx.android.synthetic.main.fragment_l.*

class LFragment  : Fragment(){

    var  hashMap = HashMap<Int,People>()
    var viewModel:VLViewModle = VLViewModle()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_l,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = activity?.let { ViewModelProvider(it).get(VLViewModle::class.java) }!!
//        viewModel.mutableLiveData.value = 20
        tv_left_plus.setOnClickListener(View.OnClickListener { viewModel.clickplus() })
        tv_left_subtraction.setOnClickListener(View.OnClickListener { viewModel.clickSub() })

        var a = hashMap.put(1,People("11","22"))
        var handler = Handler()

    }


  /*
    kotlin 中 abstract 类不能直接new 只能通过其子类来new 其实例
    class onBackChild : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().onBackPressedDispatcher.addCallback(this,onBackChild())
    }*/




}