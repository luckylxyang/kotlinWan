package com.lxy.kotlinwan.springTravel.model

data class STResource<T>(
    val error_code: Int,
    val reason: String,
    val result: T,
    val resultcode: String
)