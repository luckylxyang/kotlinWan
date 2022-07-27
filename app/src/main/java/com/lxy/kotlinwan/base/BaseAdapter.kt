package com.lxy.kotlinwan.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T>() : RecyclerView.Adapter<BaseAdapter.ViewBindHolder>() {
    private val mList = mutableListOf<T>()
    private lateinit var mContext : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseAdapter.ViewBindHolder {
        mContext = parent.context

        return ViewBindHolder(createViewBinding(parent, viewType))
    }

    override fun onBindViewHolder(holder: BaseAdapter.ViewBindHolder, position: Int) {

    }

    override fun getItemCount(): Int = mList.size

    abstract fun createViewBinding(parent: ViewGroup, viewType: Int) : ViewBinding

    class ViewBindHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}