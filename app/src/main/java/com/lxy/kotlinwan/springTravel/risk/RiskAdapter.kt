package com.lxy.kotlinwan.springTravel.risk

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.QuickAdapterHelper
import com.lxy.kotlinwan.databinding.ItemRiskCityBinding
import com.lxy.kotlinwan.springTravel.risk.model.RiskArea

class RiskAdapter() : BaseQuickAdapter<RiskArea, RiskAdapter.ViewBindHolder>() {

    class ViewBindHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onBindViewHolder(holder: ViewBindHolder, position: Int, item: RiskArea) {
        val  binding = holder.binding as ItemRiskCityBinding
        binding.itemTitle.text = item.area_name
    }

    override fun onCreateViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: Int
    ): ViewBindHolder {
        return ViewBindHolder(ItemRiskCityBinding.inflate(LayoutInflater.from(context), parent, false))
    }
}