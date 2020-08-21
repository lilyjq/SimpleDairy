package com.mercury.common.base

data class BaseResponse<T> (
    var data: T?,
    var result: T?,
    var errorCode: Int,
    var error: Int = -1,
    var errorMsg: String? = null,
    var datas :T?

)