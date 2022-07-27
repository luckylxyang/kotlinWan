package com.lxy.kotlinwan.network

import com.lxy.kotlinwan.entity.Data
import com.lxy.kotlinwan.login.data.model.UserEntiry
import retrofit2.http.*

interface ApiService {

    @POST("user/login")
    @FormUrlEncoded
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Resource<UserEntiry>

    /**
     * 获取文章列表
     */
    @GET("article/list/{pageIndex}/json")
    suspend fun getArticles(@Path("pageIndex") index: Int): Resource<Data>
}