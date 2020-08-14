package com.mercury.common.base

import android.view.View
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

open class BasePresenter <V: IView> : IPresenter<V>{

    private lateinit var weakReference:WeakReference<V>
    private  var compositeDisposable = CompositeDisposable()


    override fun attachView(view : V) {
        weakReference = WeakReference(view)
    }

    override fun dettachView() {
        weakReference.clear()
    }

    override fun isViewAttached(): Boolean {
        return weakReference.get() != null
    }

    override fun getView(): V? {
        return weakReference.get()
    }

//    fun<T> addSubscribe(observable: Observable<BaseResponse<T>>, baseObserver: Observer<T>){
//
//    }

    fun bindObserver(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    fun unbindObserver(){
        compositeDisposable.clear()
    }
}
