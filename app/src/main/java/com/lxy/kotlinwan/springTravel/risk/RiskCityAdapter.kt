package com.lxy.kotlinwan.springTravel.risk

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.lxy.kotlinwan.base.BaseAdapter
import com.lxy.kotlinwan.databinding.ItemRiskCityBinding
import com.lxy.kotlinwan.springTravel.risk.model.RiskArea
import com.lxy.kotlinwan.springTravel.risk.model.RiskRegion

class RiskCityAdapter() : BaseAdapter<RiskArea>() {

    override fun createViewBinding(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): ViewBinding {
        Log.d("TAG", "createViewBinding: ")
        return ItemRiskCityBinding.inflate(inflater, parent, false)
    }

    override fun convert(viewHolder: ViewBindHolder, t: RiskArea, position: Int) {
        val holder = viewHolder as ItemRiskCityBinding
        holder.itemTitle.text = t.area_name
    }
}