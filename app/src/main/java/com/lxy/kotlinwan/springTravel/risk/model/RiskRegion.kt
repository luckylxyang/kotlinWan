package com.lxy.kotlinwan.springTravel.risk.model

data class RiskRegion(
    val high_count: String,
    val high_list: List<RiskArea>,
    val middle_count: String,
    val middle_list: List<RiskArea>,
    val updated_date: String
)