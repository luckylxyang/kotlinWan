package com.lxy.kotlinwan.network

data class Resource<T>(
    val `data`: T,
    val errorCode: Int,
    val errorMsg: String
)