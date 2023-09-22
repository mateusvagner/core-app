package com.mv.coreapp.data

sealed class CoreResult<out R> {
    data class Success<out T>(val data: T) : CoreResult<T>()
    data class Error(val exception: Exception) : CoreResult<Nothing>()
}

val <T> CoreResult<T>.data: T?
    get() = (this as? CoreResult.Success)?.data
