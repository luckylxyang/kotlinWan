package com.lxy.kotlinwan.springTravel.risk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lxy.kotlinwan.R

class RiskCityActivity : AppCompatActivity() {

    private val model : RiskCityViewModel by lazy {
        RiskCityViewModel(RiskRepo())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_risk_city)

        model.getRiskCity()
    }
}