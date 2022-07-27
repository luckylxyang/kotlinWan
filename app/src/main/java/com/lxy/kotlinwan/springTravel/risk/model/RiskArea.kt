package com.lxy.kotlinwan.springTravel.risk.model

data class RiskArea(
    val area_name: String,
    val city: String,
    val communitys: List<String>,
    val county: String,
    val county_code: String,
    val province: String,
    val type: String
)