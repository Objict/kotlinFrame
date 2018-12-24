package com.example.kin.kotlindemo.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.example.kin.kotlindemo.R
import kotlinx.android.synthetic.main.base_action_bar_layout.view.*

class CustomTitleBar(context: Context?) : LinearLayout(context) {
    var titleBar: View? = null

    init {
        initView()
    }

    private fun initView() {
        titleBar = LayoutInflater.from(context).inflate(R.layout.base_action_bar_layout, this, true)
    }

    fun getBackBtn() = titleBar!!.iv_base_back

    fun getTitleTv() = titleBar!!.tv_base_title

    fun getRightBtn() = titleBar!!.iv_right_btn

    fun getRightText() = titleBar!!.iv_right_text
}