package com.miroinvest.data.domain.base

sealed class Resource<out R> {
    data object Loading : Resource<Nothing>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val exception: String) : Resource<Nothing>()
}