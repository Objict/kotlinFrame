package com.example.kin.kotlindemo.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * recycleView adapter,支持多布局
 */
abstract class BaseRecycleAdapter<T>(private val context: Context, private val data: ArrayList<T>) : RecyclerView.Adapter<BaseRecycleAdapter.BaseHolder<T>>() {

    protected var holder: BaseHolder<T>? = null
    protected var root: ViewGroup? = null
    protected lateinit var onItemClick: ((T, Int) -> Unit)
    protected lateinit var onItemLongClick: ((T, Int) -> Unit)


    override fun onCreateViewHolder(root: ViewGroup, type: Int): BaseHolder<T> {
        this.root = root
        return customViewHolder(root, type)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BaseHolder<T>, position: Int) {
        this.holder = holder
    }

    open fun customViewHolder(root: ViewGroup, type: Int): BaseHolder<T> {
        return BaseHolder(getLayoutView(getLayoutResourceId()), getData())
    }

    open fun getLayoutView(resId: Int): View {
        return LayoutInflater.from(context).inflate(resId, root, false)
    }

    fun addItemClickListener(listen: ((T, Int) -> Unit)) {
        this.onItemClick = listen
    }

    fun addItemLongClickListener(longClicklistener: ((T, Int) -> Unit)) {
        this.onItemLongClick = longClicklistener
    }

    fun getData(): ArrayList<T> {
        return data
    }

    abstract fun getLayoutResourceId(): Int


    open class BaseHolder<T>(item: View, data: ArrayList<T>) : RecyclerView.ViewHolder(item) {
        private var v: View? = null
        private var data: ArrayList<T>? = null

        init {
            v = item
            this.data = data
        }

        open fun setData(position: Int, data: ArrayList<T>, listener: (T, Int) -> Unit) {

        }

        fun getView(resId: Int): View? {
            return v!!.findViewById(resId)
        }

        fun getTextView(resId: Int): TextView? {
            return v!!.findViewById(resId)
        }
    }
}