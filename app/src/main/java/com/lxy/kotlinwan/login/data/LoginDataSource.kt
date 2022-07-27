package com.lxy.kotlinwan.login.data

import com.lxy.kotlinwan.login.data.model.LoggedInUser
import com.lxy.kotlinwan.login.data.model.UserEntiry
import com.lxy.kotlinwan.network.Resource
import com.lxy.kotlinwan.network.RetrofitManager
import java.io.IOException
import java.lang.IllegalArgumentException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    suspend fun login(username: String, password: String): Result<UserEntiry> {
        val resource = RetrofitManager.getApiService().login(username, password)
        if (resource.errorCode == 0){
            return Result.Success(resource.data)
        }
        return Result.Error(IllegalArgumentException(resource.errorMsg))
    }

    fun logout() {
    }
}