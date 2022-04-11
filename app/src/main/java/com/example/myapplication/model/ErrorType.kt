package com.example.myapplication.model

enum class ErrorType {
    NETWORK,
    TIMEOUT,
    SESSION_EXPIRED,
    UNKNOWN
}

enum class Status{
    SUCCESS,
    ERROR,
    LOADING
}