package com.samir.androidapptesting.data

sealed class NetworkState<out T> {
    data class Success<out T>(val data:T?): NetworkState<T>()
    data class Error(val message:String?, val code:Int?=0): NetworkState<Nothing>()
    object Loading: NetworkState<Nothing>()
}