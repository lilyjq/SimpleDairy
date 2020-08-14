package com.mercury.common.net

class ServiceUtil {
    companion object{
        fun getService():ApiService{
                return NetUtil.get().getRetrofit().create(ApiService::class.java)
        }
    }
}