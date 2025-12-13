package com.samir.androidapptesting.data.service

import com.samir.androidapptesting.data.APIService
import com.samir.androidapptesting.data.apiresponse.UserResponse
import retrofit2.Response

class ApiServiceHelperImpl(val apiService: APIService): ApiServiceHelper {
    override suspend fun getUsers(): Response<UserResponse> {
        return apiService.getUsers()
    }
}