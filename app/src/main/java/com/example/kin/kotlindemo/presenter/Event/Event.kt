package com.example.kin.kotlindemo.presenter.Event

import android.content.Context

/**
 *作者：kin
 *时间:2018/12/28 10:22
 *email:549064230@qq.com
 */
interface Event {
    fun getContext():Context

    interface MainActivityEvent : Event{

        fun getUser(result:String)
    }
}