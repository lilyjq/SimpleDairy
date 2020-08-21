package com.mercury.test

/**
 * double check
 */
class LazySingleton private constructor(){

    companion object{
        val instance:LazySingleton by lazy {
            LazySingleton()

        }
    }

    fun caculate(){

    }

}
