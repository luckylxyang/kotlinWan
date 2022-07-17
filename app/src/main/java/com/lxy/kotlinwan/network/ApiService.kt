package com.lxy.kotlinwan.network

import retrofit2.http.*

interface ApiService {

    @POST("user/login")
    @FormUrlEncoded
    suspend fun login(@Field("username") username : String, @Field("password") password :String)

    /**
     * 获取文章列表
     */
    @GET("article/list/{pageIndex}/json")
    suspend fun getArticles(@Path("pageIndex") index: Int) : Resource<Data>
}