package com.mercury.common.base

import io.reactivex.observers.DisposableObserver

class BaseObserver<T> : DisposableObserver<BaseResponse<T>>{

    private var baseView:IView? = null

    constructor():super()

    constructor(view:IView?):super(){
        baseView = view
    }





    override fun onStart() {
        super.onStart()
//        baseView.showloading
    }
    override fun onComplete() {
        TODO("Not yet implemented")
    }

    override fun onNext(t: BaseResponse<T>) {
        TODO("Not yet implemented")
    }

    override fun onError(e: Throwable) {
        TODO("Not yet implemented")
    }
}