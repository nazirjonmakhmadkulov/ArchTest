package com.example.common.network


sealed class Result<out T> {
    object Loading : Result<Nothing>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val cause: HttpResult, val code : Int? = null, val errorMessage : String? = null) : Result<Nothing>()
}