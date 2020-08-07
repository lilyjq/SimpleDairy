package com.mercury.common.base

abstract class BaseMVPActivity<V:IView,P:IPresenter<V>>: BaseActivity(),IView {

    lateinit var presenter:P

    override fun initData() {
        presenter = createPresent()
        presenter.attachView(this as V)
    }

    abstract fun createPresent(): P
}