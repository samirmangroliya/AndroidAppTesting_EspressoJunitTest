package com.samir.androidapptesting.data

import com.samir.androidapptesting.data.apiresponse.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("users")
    suspend fun getUsers(): Response<UserResponse>
}