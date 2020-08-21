package com.mercury.common.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetUtil private constructor() {

    private val baseUrl = "https://www.wanandroid.com";
    private var retrofit: Retrofit
    private var okHttpClient: OkHttpClient =
        OkHttpClient.Builder().addInterceptor(LoggingInterceptor())
            .connectTimeout(10, TimeUnit.SECONDS)
            .callTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()

    init {
        retrofit = Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }


    companion object {
       val instance = Holder.holer


        @Synchronized
        fun get(): NetUtil {
            return instance
        }

    }

    private object Holder{
        val holer = NetUtil()
    }

    public fun getRetrofit(): Retrofit {
        return  retrofit
    }


}