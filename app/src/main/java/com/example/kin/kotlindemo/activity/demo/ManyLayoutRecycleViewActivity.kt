package com.example.kin.kotlindemo.activity.demo

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.kin.kotlindemo.R
import com.example.kin.kotlindemo.base.BaseKotlinActivity
import com.example.kin.kotlindemo.base.BaseRecycleAdapter
import kotlinx.android.synthetic.main.activity_simple_recycle_view_layout.*

/**
 * 多布局RecycleView demo
 */
class ManyLayoutRecycleViewActivity : BaseKotlinActivity() {

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_simple_recycle_view_layout
    }

    override fun initData(savedInstanceState: Bundle?) {
        setTitle("多布局RecycleView")

        rlv_simple_recycle.layoutManager = LinearLayoutManager(this)
        val adapterData = ArrayList<String>()
        for (value in 1..100) {
            when (value % 3) {
                0 -> adapterData.add("聊天内容" + value)
                1 -> adapterData.add("2018/12/25")
                else -> adapterData.add("聊天内容" + value)
            }
        }
        val adapter = RecycleAdapter(this, adapterData)
        rlv_simple_recycle.adapter = adapter
        adapter.addItemClickListener { value, positon -> Toast.makeText(this, value, Toast.LENGTH_SHORT).show() }
    }


    class RecycleAdapter(context: Context, data: ArrayList<String>) : BaseRecycleAdapter<String>(context, data) {
        private val TYPE_TEXT = 0X1
        private val TYPE_IMAGE = 0X2
        private val TYPE_TEXT_IMAGE = 0X3

        override fun getLayoutResourceId(): Int {
            return 0
        }

        override fun onBindViewHolder(holder: BaseHolder<String>, position: Int) {
            super.onBindViewHolder(holder, position)
            holder.setData(position, getData(), onItemClick)
        }

        override fun getItemViewType(position: Int): Int {
            return when (position % 3) {
                0 -> TYPE_TEXT
                1 -> TYPE_IMAGE
                2 -> TYPE_TEXT_IMAGE
                else -> 0
            }
        }

        override fun customViewHolder(root: ViewGroup, type: Int): BaseHolder<String> {
            return when (type) {
                TYPE_TEXT -> TimeHolder(getLayoutView(R.layout.item_many_layout_recycle_layout_text), getData())

                TYPE_IMAGE -> RightHolder(getLayoutView(R.layout.item_many_layout_recycle_layout_image), getData())

                else -> LeftHolder(getLayoutView(R.layout.item_many_layout_recycle_layout_text_and_image), getData())
            }
        }

        /**
         * 不同的布局使用不同的ViewHolder,各自的holder管理各自的布局
         */

        class TimeHolder(item: View, data: ArrayList<String>) : BaseHolder<String>(item, data) {

            override fun setData(position: Int, data: ArrayList<String>, listener: (String, Int) -> Unit) {
                super.setData(position, data, listener)
                val value = data[position]
                val textView = (getView(R.id.tv_content) as TextView)
                if (position % 12 == 0) {
                    textView.text = value
                } else {
                    textView.text = ""
                }
                textView.setOnClickListener { listener.invoke(value, position) }
            }
        }

        class LeftHolder(item: View, data: ArrayList<String>) : BaseHolder<String>(item, data) {


            override fun setData(position: Int, data: ArrayList<String>, listener: (String, Int) -> Unit) {
                super.setData(position, data, listener)
                val value = data[position]
                val textView = (getView(R.id.tv_content) as TextView)
                textView.text = value
                getView(R.id.iv_content)!!.setOnClickListener { listener.invoke(value, position) }
            }
        }

        class RightHolder(item: View, data: ArrayList<String>) : BaseHolder<String>(item, data) {


            override fun setData(position: Int, data: ArrayList<String>, listener: (String, Int) -> Unit) {
                super.setData(position, data, listener)
                val value = data[position]
                val textView = (getView(R.id.tv_content) as TextView)
                textView.text = value
                getView(R.id.iv_content)!!.setOnClickListener { listener.invoke(value, position) }
            }
        }

    }

}