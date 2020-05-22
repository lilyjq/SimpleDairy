package com.mercury.diary

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class Test : AppCompatActivity() {
    var name :String = "Holmes Sherlock"
    var city :String = "London"
    val size = 1
    val isEmpty: Boolean get() = this.size== 0
    val a2:String by lazy { "11232223" }

    lateinit var a1:String

    fun copyAddress(adress:String):Int{
        return adress.toInt()

    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        a1 = "122222"
    }
}