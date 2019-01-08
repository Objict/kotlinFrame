package com.example.kin.kotlindemo

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kin.kotlindemo.activity.demo.ManyLayoutRecycleViewActivity
import com.example.kin.kotlindemo.activity.demo.SimpleRecycleViewActivity
import com.example.kin.kotlindemo.db.gen.DbManager
import com.example.kin.kotlindemo.db.entity.KUser
import com.example.kin.kotlindemo.presenter.Event.Event
import com.example.kin.kotlindemo.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),Event.MainActivityEvent {

    private var  mPresenter:MainActivityPresenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = MainActivityPresenter(this)

        btn_simple.setOnClickListener {
            startActivity(Intent(this,SimpleRecycleViewActivity::class.java))
        }
        btn_many_layout.setOnClickListener {
            startActivity(Intent(this,ManyLayoutRecycleViewActivity::class.java))
        }

        btn_create_db.setOnClickListener { DbManager() }

        btn_search_data.setOnClickListener {
           mPresenter!!.getUser(edt_key.text.toString())

        }

    }

    override fun getContext():Context {
        return this
    }

    override fun getUser(result: String) {
        tv_show.text = result
    }
}
