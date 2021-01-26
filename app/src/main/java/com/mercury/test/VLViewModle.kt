package com.mercury.test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VLViewModle : ViewModel {

    //livedata 观察者模式 数据发生改变，观察者立即能收到通知
    //viewModel  可以用它来管理页面的全局变量
     var mutableLiveData:MutableLiveData<Int> = MutableLiveData()

    constructor(){
        mutableLiveData.value = 0
    }

    fun clickplus(){
        mutableLiveData.value = mutableLiveData.value?.plus(1)
    }

    fun clickSub(){
        mutableLiveData.value = mutableLiveData.value?.minus(1)

    }


}