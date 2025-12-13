package com.samir.androidapptesting.data.repo

import com.samir.androidapptesting.data.NetworkState
import com.samir.androidapptesting.data.service.ApiServiceHelper
import com.samir.androidapptesting.domain.repo.UserRepo
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class UserRepoImpl(private val apiServiceHelper: ApiServiceHelper) : UserRepo {
    override suspend fun getUsers() =
        flow {
            emit(NetworkState.Loading)
            with(apiServiceHelper.getUsers()) {
                if (isSuccessful) {
                    emit(NetworkState.Success(this.body()?.users))
                } else {
                    emit(NetworkState.Error(this.errorBody()?.string(), this.code()))
                }
            }
        }.catch { emit(NetworkState.Error(it.localizedMessage)) }
}