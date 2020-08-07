package com.mercury.common.net

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

fun LoggingInterceptor() : Interceptor {
  return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}
