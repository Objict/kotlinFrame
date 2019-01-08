package com.example.kin.kotlindemo

import android.app.Application
import com.example.kin.kotlindemo.utils.ToastUtils

/**
 *作者：kin
 *时间:2018/12/25 14:24
 *email:549064230@qq.com
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        ToastUtils.bindContext(this)

    }
    companion object {
        var instance: MyApp? = null
        fun getInstanc(): MyApp? {
            if (instance == null) {
                instance = MyApp()
            }
            return instance
        }
    }
}