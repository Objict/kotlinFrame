package com.example.kin.kotlindemo.utils

import android.content.Context
import android.support.annotation.StringRes
import android.widget.Toast

/**
 *作者：kin
 *时间:2018/12/25 11:52
 *email:549064230@qq.com
 */
class ToastUtils {

    companion object {
        private lateinit var context: Context

        fun bindContext(context: Context) {
            this.context = context
        }

        fun show(string: String) {
            Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
        }

        fun show(@StringRes str:Int){
            show(context.getString(str))
        }
    }



}