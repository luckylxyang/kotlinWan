package com.lxy.kotlinwan.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T>() : RecyclerView.Adapter<BaseAdapter.ViewBindHolder>() {
    val mList = mutableListOf<T>()
    lateinit var mContext : Context
    private lateinit var mItemClick : OnItemClickListener<T>
    private lateinit var mItemLongClick : OnItemLongClickListener<T>
    private val mChildClicks = mutableMapOf<Int, OnItemClickListener<T>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewBindHolder {
        mContext = parent.context

        return ViewBindHolder(createViewBinding(LayoutInflater.from(mContext), parent, viewType))
    }

    override fun onBindViewHolder(viewHolder: ViewBindHolder, position: Int) {
        val entity = mList[position]
        convert(viewHolder, entity, position)
        viewHolder.itemView.setOnClickListener {
            mItemClick?.onItemClick(it, entity, position)
        }
        viewHolder.itemView.setOnLongClickListener {
            mItemLongClick?.onItemLongClick(it, entity, position)
            return@setOnLongClickListener true
        }
        mChildClicks.forEach { (viewId, onItemClickListener) ->
            run {
                viewHolder.itemView.findViewById<View>(viewId)?.setOnClickListener {
                    onItemClickListener?.onItemClick(it, entity, position)
                }
            }
        }
    }

    override fun getItemCount(): Int = mList.size

    abstract fun createViewBinding(inflater: LayoutInflater, parent: ViewGroup, viewType: Int) : ViewBinding

    abstract fun convert(viewHolder: ViewBindHolder, t : T, position: Int )

    class ViewBindHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    fun setData(list: List<T>){
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }

    fun addData(list: List<T>, position: Int){
        mList.addAll(position, list)
        notifyItemRangeInserted(position, list.size)
    }

    fun addData(list: List<T>){
        val startIndex = mList.size
        mList.addAll(list)
        notifyItemRangeInserted(startIndex - 1, list.size)
    }

    fun removeAll(){
        mList.clear()
        notifyDataSetChanged()
    }

    fun removeIndex(position: Int){
        if (position >= mList.size) return
        mList.remove(mList[position])
        notifyItemRemoved(position)
    }

    fun removeRange(startPosition : Int , end : Int){
        if (end < startPosition) return
        mList.removeAll(mList.subList(startPosition, end))
        notifyItemRangeRemoved(startPosition, end - startPosition)
    }

    fun setOnItemClickListener(listener: OnItemClickListener<T>){
        mItemClick = listener
    }

    fun setOnItemChildClickListener(viewId : Int,listener: OnItemClickListener<T>){
        mChildClicks[viewId] = listener
    }

    fun setOnItemLoneClickListener(listener: OnItemLongClickListener<T>){
        mItemLongClick = listener
    }

    interface OnItemClickListener<T>{
        fun onItemClick(view : View, t : T, position: Int)
    }


    interface OnItemLongClickListener<T>{
        fun onItemLongClick(view : View, t : T, position: Int)
    }
}