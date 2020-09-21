package com.mercury.common.net

import com.mercury.common.base.BaseResponse
import com.mercury.diary.home.bean.HomeArticleBean
import com.mercury.diary.home.bean.HomeArticleResponse
import com.mercury.diary.home.bean.HomeBannerBean
import com.mercury.diary.project.bean.ProjectTypeBean
import com.mercury.diary.system.bean.SystemBean
import com.mercury.diary.system.bean.SystemSecondBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService  {

    @GET("/banner/json")
    fun getBanner(): Observable<BaseResponse<List<HomeBannerBean>>>
    /**
     * https://www.wanandroid.com/article/list/0/json
     */
    @GET("/article/list/{page}/json")
    fun getHomePageArticle(@Path("page") page:Int):Observable<BaseResponse<HomeArticleResponse>>



    @GET("/project/tree/json")
    fun getProjectType():Observable<BaseResponse<List<ProjectTypeBean>>>


    /**
     * https://www.wanandroid.com/project/list/1/json?cid=294
     */

    @GET("/project/list/{page}/json")
    fun getProjectByTypeId(@Path("page")page: Int,@Query("cid")cid:Int):Observable<BaseResponse<HomeArticleResponse>>


    @GET("/tree/json")
    fun getSystem():Observable<BaseResponse<List<SystemBean>>>

    /**
     * ：https://www.wanandroid.com/article/list/0/json?cid=60
     */
    @GET("/article/list/{page}/json")
    fun getSecondSystem(@Path("page")page:Int,@Query("cid") cid :Int):Observable<BaseResponse<SystemSecondBean>>


}