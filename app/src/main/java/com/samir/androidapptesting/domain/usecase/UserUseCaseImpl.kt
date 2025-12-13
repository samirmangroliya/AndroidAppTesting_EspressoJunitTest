package com.samir.androidapptesting.domain.usecase

import com.samir.androidapptesting.data.NetworkState
import com.samir.androidapptesting.data.models.User
import com.samir.androidapptesting.domain.repo.UserRepo
import kotlinx.coroutines.flow.Flow

class UserUseCaseImpl(val userRepo: UserRepo): UserUseCase {
    override suspend fun getUsers(): Flow<NetworkState<List<User?>>> {
         return userRepo.getUsers()
    }
}