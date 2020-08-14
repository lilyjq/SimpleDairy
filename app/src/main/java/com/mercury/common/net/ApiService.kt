package com.mercury.common.net

import com.mercury.common.base.BaseResponse
import com.mercury.diary.home.bean.HomeArticleBean
import com.mercury.diary.home.bean.HomeArticleResponse
import com.mercury.diary.home.bean.HomeBannerBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService  {

    @GET("/banner/json")
    fun getBanner(): Observable<BaseResponse<List<HomeBannerBean>>>
    /**
     * https://www.wanandroid.com/article/list/0/json
     */
    @GET("/article/list/{page}/json")
    fun getHomePageArticle(@Path("page") page:Int):Observable<BaseResponse<HomeArticleResponse>>





}