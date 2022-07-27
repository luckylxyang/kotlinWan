package com.lxy.kotlinwan.springTravel

import com.lxy.kotlinwan.springTravel.model.STResource
import com.lxy.kotlinwan.springTravel.risk.model.RiskRegion
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface SpringTravelService {

    @Headers("urlname:test1")
    @GET("springTravel/risk")
    suspend fun risk(@Query("key") key : String = STConstants.KEY) : STResource<RiskRegion>
}