package com.lxy.kotlinwan.network

import com.lxy.kotlinwan.springTravel.SpringTravelService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {

    const val BASE_URL_ST = "http://apis.juhe.cn/"

    private const val BASE_URL = "https://www.wanandroid.com"       //根路径

    private val loggingInterceptor = HttpLoggingInterceptor().also {
        it.level = HttpLoggingInterceptor.Level.BODY
    }




    var client = OkHttpClient.Builder()
        //自定义拦截器用于日志输出
        .addInterceptor(BaseUrlInterceptor())
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())     //添加用于解析数据的转换库
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    fun getApiService() : ApiService = retrofit.create(ApiService::class.java)

    fun getSTService() : SpringTravelService = retrofit.create(SpringTravelService::class.java)
}