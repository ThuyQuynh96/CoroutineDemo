package com.example.myapplication.model

interface BaseError {
    fun onError(msg: String)
    fun onError(errorType: ErrorType)
}

