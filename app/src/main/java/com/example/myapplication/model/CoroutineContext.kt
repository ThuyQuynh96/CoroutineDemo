package com.example.myapplication.model

import android.accounts.NetworkErrorException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.HttpException
import java.net.SocketTimeoutException

abstract class CoroutineContext {
    companion object {
        private const val TAG = "Repository"
        private const val MESSAGE_KEY = "message"
        private const val ERROR_KEY = "error"
    }


    suspend inline fun <T> callApi(
        error: BaseError, crossinline callFunction: suspend () -> T
    ): T? {
        return try {
            val myObject = withContext(Dispatchers.IO) { callFunction.invoke() }
            myObject
        } catch (ex: Exception) {
            withContext(Dispatchers.Main) {
                ex.printStackTrace()
                when (ex) {
                    is HttpException -> {
                        if (ex.code() == 401) error.onError(ErrorType.SESSION_EXPIRED)
                        else {
                            val body = ex.response()?.errorBody()!!
                            error.onError(getErrorMessage(body))
                        }
                    }
                    is SocketTimeoutException -> error.onError(ErrorType.TIMEOUT)
                    is NetworkErrorException -> error.onError(ErrorType.NETWORK)
                    else -> error.onError(ErrorType.UNKNOWN)
                }
            }
            null
        }
    }

    fun getErrorMessage(responseBody: ResponseBody): String {
        return try {
            val json = JSONObject(responseBody.toString())
            when {
                json.has(MESSAGE_KEY) -> json.getString(MESSAGE_KEY)
                json.has(ERROR_KEY) -> json.getString(ERROR_KEY)
                else -> "Something wrong happened"
            }
        } catch (e: Exception) {
            "Something wrong happened"
        }
    }
}