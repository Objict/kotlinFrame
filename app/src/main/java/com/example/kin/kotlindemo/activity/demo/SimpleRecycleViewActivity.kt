package com.example.kin.kotlindemo.activity.demo

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import android.widget.Toast
import com.example.kin.kotlindemo.R
import com.example.kin.kotlindemo.base.BaseKotlinActivity
import com.example.kin.kotlindemo.base.BaseRecycleAdapter
import kotlinx.android.synthetic.main.activity_simple_recycle_view_layout.*

class SimpleRecycleViewActivity : BaseKotlinActivity() {
    override fun getLayoutResourceId(): Int {
        return R.layout.activity_simple_recycle_view_layout
    }

    override fun initData(savedInstanceState: Bundle?) {
        isShowTitleBar(true)
        setTitle("简单的RecycleView")
        val adapterData = ArrayList<String>()
        for (index in 1..10) {
            adapterData.add("第" + index + "item")
        }
        val adapter = SimpleAdapter(this, adapterData)
        rlv_simple_recycle.layoutManager = LinearLayoutManager(this)
        rlv_simple_recycle.adapter = adapter
        adapter.addItemClickListener{value,positon-> Toast.makeText(this,value,Toast.LENGTH_SHORT).show() }
    }

    class SimpleAdapter(context: Context, data: ArrayList<String>) : BaseRecycleAdapter<String>(context, data) {

        override fun getLayoutResourceId(): Int {
            return R.layout.item_simple_recycle_layout
        }

        override fun onBindViewHolder(holder: BaseHolder<String>, position: Int) {
            super.onBindViewHolder(holder, position)
            val text = (holder.getView(R.id.tv_content) as TextView)
            text.text = getData()[position]
            text.setOnClickListener { onItemClick.invoke(getData()[position],position) }
        }

    }
}