package com.mercury.common.base

abstract class BaseMVPFragment<V : IView, P : IPresenter<V>> : BaseFragment(), IView {

    lateinit var presenter: P

    override fun initData() {
        presenter = createPresent()
        presenter.attachView(this as V)
    }

    abstract fun createPresent(): P
    
    
    fun showLoadingDialog(){
        
    }
    
    fun hideLoadingDialog(){
        
    }


}
