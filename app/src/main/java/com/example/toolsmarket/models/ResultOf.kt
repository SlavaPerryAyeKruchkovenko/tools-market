package com.example.toolsmarket.models

sealed class ResultOf<out T> {
    data class Success<out R>(val value: R): ResultOf<R>()
    data class Failure(
        val message: String?,
        val moreInfo: String?
    ): ResultOf<Nothing>()
}