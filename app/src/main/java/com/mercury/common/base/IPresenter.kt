package com.mercury.common.base

interface IPresenter<V:IView>{

    fun attachView(view:V)
    fun dettachView()
    fun isViewAttached():Boolean
    fun getView():V?
}