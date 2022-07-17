package com.lxy.kotlinwan.network

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {



    @GET("article/list/{pageIndex}/json")
    suspend fun getArticles(@Path("pageIndex") index: Int) : Resource<Data>
}