package com.mercury.diary.project

import androidx.paging.PageKeyedDataSource
import com.mercury.diary.home.bean.HomeArticleBean

class ProjectDataSource : PageKeyedDataSource<Int, HomeArticleBean>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, HomeArticleBean>
    ) {
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, HomeArticleBean>) {
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, HomeArticleBean>) {
    }
}