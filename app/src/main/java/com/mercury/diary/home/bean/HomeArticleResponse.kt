package com.mercury.diary.home.bean

data class HomeArticleResponse(
    var curPage: Int,
    var dates: List<HomeArticleBean>,
    var offset: Int,
    var over: Boolean,
    var pageCount: Int,
    var size: Int,
    var total: Int
)