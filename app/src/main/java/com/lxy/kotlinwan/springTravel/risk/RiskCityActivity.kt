package com.lxy.kotlinwan.springTravel.risk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.lxy.kotlinwan.R
import com.lxy.kotlinwan.base.BaseActivity
import com.lxy.kotlinwan.databinding.ActivityRiskCityBinding

class RiskCityActivity : BaseActivity() {

    private val binding: ActivityRiskCityBinding by lazy {
        ActivityRiskCityBinding.inflate(layoutInflater)
    }

    private val model : RiskCityViewModel by lazy {
        RiskCityViewModel(RiskRepo())
    }

    private val adapter : RiskCityAdapter by lazy {
        RiskCityAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_risk_city)

        adapter.let {

        }
        binding.rvCity.run {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
            adapter = adapter
        }

        model.getCities().observe(this){
            adapter.addData(it.high_list)
        }
    }
}