package com.lxy.kotlinwan.springTravel.risk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.QuickAdapterHelper
import com.lxy.kotlinwan.R
import com.lxy.kotlinwan.base.BaseActivity
import com.lxy.kotlinwan.databinding.ActivityRiskCityBinding
import com.lxy.kotlinwan.springTravel.risk.model.RiskArea

class RiskCityActivity : BaseActivity() {

    private val binding: ActivityRiskCityBinding by lazy {
        ActivityRiskCityBinding.inflate(layoutInflater)
    }

    private val model: RiskCityViewModel by lazy {
        RiskCityViewModel(RiskRepo())
    }

    private val adapter: RiskCityAdapter by lazy {
        RiskCityAdapter()
    }

    private val mAdapter: RiskAdapter by lazy {
        RiskAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter.let {

        }
        val build = QuickAdapterHelper.Builder(mAdapter)
            .build()
        binding.rvCity.let {
            it.layoutManager = LinearLayoutManager(this)
            it.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
            it.adapter = build.contentAdapter
        }
        mAdapter.setOnItemClickListener { adapter, view, position ->
            run {
                Toast.makeText(this, adapter.getItem(position).area_name, Toast.LENGTH_SHORT).show()
            }
        }
        mAdapter.setOnItemLongClickListener { adapter, view, position ->
            Toast.makeText(this, "$position", Toast.LENGTH_SHORT).show()
            return@setOnItemLongClickListener true
        }
//        binding.rvCity.layoutManager = LinearLayoutManager(this)
//        binding.rvCity.adapter = mAdapter


        model.getCities().observe(this) {
            mAdapter.addAll(it.high_list)
        }
    }
}