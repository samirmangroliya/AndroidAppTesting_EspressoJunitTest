package com.samir.androidapptesting.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samir.androidapptesting.data.NetworkState
import com.samir.androidapptesting.data.models.User
import com.samir.androidapptesting.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userUseCase: UserUseCase) : ViewModel() {
    private val _users: MutableStateFlow<NetworkState<List<User?>>> =
        MutableStateFlow(NetworkState.Loading)
    var users = _users


    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            userUseCase.getUsers().collect {
                when (it) {
                    is NetworkState.Loading -> {
                        _users.value = NetworkState.Loading
                    }

                    is NetworkState.Success -> {
                        _users.value = NetworkState.Success(it.data)
                    }

                    is NetworkState.Error -> {
                        _users.value = NetworkState.Error(it.message)
                    }
                }
            }
        }
    }
}