package com.mercury.test

class InnerSingleton private constructor() {

    companion object{
        val instance = Holder.holder
    }

    private object Holder {
        val holder = InnerSingleton()
    }

    fun caculate(){

    }

}