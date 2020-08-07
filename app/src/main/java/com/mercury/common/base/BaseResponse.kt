package com.mercury.common.base

data class BaseResponse<T> (
    var data: T?,
    var result: T?,
    var errorCode: String,
    var error: Int = -1,
    var errorMsg: String? = null
)