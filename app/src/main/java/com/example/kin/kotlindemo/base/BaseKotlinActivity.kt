package com.example.kin.kotlindemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import com.example.kin.kotlindemo.R
import kotlinx.android.synthetic.main.activity_base_kotlin.*

abstract class BaseKotlinActivity : AppCompatActivity() {
    private var titleBar: CustomTitleBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_kotlin)
        titleBar = CustomTitleBar(this)
        ll_title_container.addView(titleBar)
        val child = LayoutInflater.from(applicationContext).inflate(getLayoutResourceId(), fl_base_container, false)
        fl_base_container.addView(child)
        initData(savedInstanceState)
        titleBar!!.getBackBtn().setOnClickListener { finish() }
    }

    abstract fun getLayoutResourceId(): Int
    abstract fun initData(savedInstanceState: Bundle?)

    fun setTitle(title: String) {
        titleBar!!.getTitleTv().text = title
    }

    fun isShowTitleBar(isShow:Boolean){
        ll_title_container.visibility = if (isShow) View.VISIBLE else View.GONE
    }
}
