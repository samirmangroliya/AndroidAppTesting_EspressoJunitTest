package com.samir.androidapptesting.di

import com.samir.androidapptesting.data.APIService
import com.samir.androidapptesting.data.service.ApiServiceHelper
import com.samir.androidapptesting.data.service.ApiServiceHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ServiceModule {
    @Provides
    fun provideApiServiceHelper(apiService: APIService): ApiServiceHelper {
        return ApiServiceHelperImpl(apiService)
    }
}