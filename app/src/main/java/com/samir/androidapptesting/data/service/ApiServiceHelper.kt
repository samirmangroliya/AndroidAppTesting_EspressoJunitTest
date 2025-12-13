package com.samir.androidapptesting.data.service

import com.samir.androidapptesting.data.apiresponse.UserResponse
import retrofit2.Response

interface ApiServiceHelper {
    suspend fun getUsers(): Response<UserResponse>
}