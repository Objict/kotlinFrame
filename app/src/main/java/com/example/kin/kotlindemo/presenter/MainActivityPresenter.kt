package com.example.kin.kotlindemo.presenter

import com.example.kin.kotlindemo.base.BasePresenter
import com.example.kin.kotlindemo.db.dao.KUserDao
import com.example.kin.kotlindemo.db.entity.KUser
import com.example.kin.kotlindemo.db.model.UserModel
import com.example.kin.kotlindemo.presenter.Event.Event
import com.example.kin.kotlindemo.utils.ToastUtils
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 *作者：kin
 *时间:2018/12/28 10:17
 *email:549064230@qq.com
 */
class MainActivityPresenter(presenterView: Event.MainActivityEvent) : BasePresenter<Event.MainActivityEvent>(presenterView) {

    fun getUser(key: String) {
        val str = StringBuffer()
        UserModel.instance.getUserBySql(key)!!
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { it ->
                    for (value in it) {
                        str.append(value.uaccount).append(";")
                    }
                     mPresenterView!!.getUser(str.toString())
                }
    }
}