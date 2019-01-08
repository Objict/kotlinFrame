package com.example.kin.kotlindemo.base

import com.example.kin.kotlindemo.presenter.Event.Event

/**
 *作者：kin
 *时间:2018/12/28 10:16
 *email:549064230@qq.com
 */

open class BasePresenter<T : Event>(presenterView: T) {

    protected var mPresenterView:T?=null
    protected var mActivity:BaseKotlinActivity?= null

    init {
        attachView(presenterView)
        if(presenterView is BaseKotlinActivity){
            mActivity = presenterView
        }
    }

    private fun attachView(presenterView:T){
        mPresenterView = presenterView
    }

    private fun onDetchView(){
        mPresenterView = null
    }

}