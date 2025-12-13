package com.samir.androidapptesting.domain.repo

import com.samir.androidapptesting.data.NetworkState
import com.samir.androidapptesting.data.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepo {
    suspend fun getUsers(): Flow<NetworkState<List<User?>>>
}