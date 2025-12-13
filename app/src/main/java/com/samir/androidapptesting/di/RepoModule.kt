package com.samir.androidapptesting.di

import com.samir.androidapptesting.data.repo.UserRepoImpl
import com.samir.androidapptesting.data.service.ApiServiceHelper
import com.samir.androidapptesting.domain.repo.UserRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepoModule {
    @Provides
    fun provideRepo(apiServiceHelper: ApiServiceHelper): UserRepo {
        return UserRepoImpl(apiServiceHelper)
    }
}