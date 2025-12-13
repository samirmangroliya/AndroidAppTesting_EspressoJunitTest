package com.samir.androidapptesting.di

import com.samir.androidapptesting.domain.repo.UserRepo
import com.samir.androidapptesting.domain.usecase.UserUseCase
import com.samir.androidapptesting.domain.usecase.UserUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    fun provideUserUseCase(userRepo: UserRepo): UserUseCase {
        return UserUseCaseImpl(userRepo)
    }
}