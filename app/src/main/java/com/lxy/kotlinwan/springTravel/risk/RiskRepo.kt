package com.lxy.kotlinwan.springTravel.risk

import com.lxy.kotlinwan.network.RetrofitManager
import com.lxy.kotlinwan.springTravel.model.STResource
import com.lxy.kotlinwan.springTravel.risk.model.RiskRegion

class RiskRepo {

    suspend fun getRiskRegion() : STResource<RiskRegion>{
        return RetrofitManager.getSTService().risk()
    }
}