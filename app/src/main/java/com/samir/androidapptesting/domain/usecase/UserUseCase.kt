package com.samir.androidapptesting.domain.usecase

import com.samir.androidapptesting.data.NetworkState
import com.samir.androidapptesting.data.models.User
import kotlinx.coroutines.flow.Flow

interface UserUseCase {
    suspend fun getUsers(): Flow<NetworkState<List<User?>>>
}