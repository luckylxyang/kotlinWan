package com.lxy.kotlinwan.network

import android.util.Log
import com.lxy.kotlinwan.springTravel.STConstants
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class BaseUrlInterceptor() : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        //获取request
        val request: Request = chain.request()
        //从request中获取原有的HttpUrl实例oldHttpUrl
        val oldHttpUrl: HttpUrl = request.url()
        //获取request的创建者builder
        val builder: Request.Builder = request.newBuilder()
        //从request中获取headers，通过给定的键url_name
        val headerValues: List<String> = request.headers("urlname")
        if (headerValues.isNotEmpty()) {
            //如果有这个header，先将配置的header删除，因此header仅用作app和okhttp之间使用
            builder.removeHeader("urlname")
            //匹配获得新的BaseUrl
            val headerValue = headerValues[0]
            var newBaseUrl: HttpUrl? = null
            newBaseUrl = if ("test1" == headerValue) {
                HttpUrl.parse(RetrofitManager.BASE_URL_ST)
            } else {
                oldHttpUrl
            }
            //重建新的HttpUrl，修改需要修改的url部分
            val newFullUrl = oldHttpUrl
                .newBuilder()
                .scheme("https")
                .host(newBaseUrl!!.host()) //更换主机名
//                .removePathSegment(0) //移除第一个参数
                .build()
            //重建这个request，通过builder.url(newFullUrl).build()；
            // 然后返回一个response至此结束修改
            Log.e("Url", "intercept: $newFullUrl")
            return chain.proceed(builder.url(newFullUrl).build())
        }
        return chain.proceed(request)
    }
}