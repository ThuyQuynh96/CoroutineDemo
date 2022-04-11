package com.example.myapplication.ui.base

import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.response.ConsolidatedResponse
import com.example.myapplication.data.repository.Repository
import com.example.myapplication.data.response.SearchResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

open class BaseViewModel(private val repository: Repository) : ViewModel() {

    private var date = Date()
    private var currentTime = SimpleDateFormat("yyyy/MM/dd").format(date)
    var job: Job? = null
    internal val loading = MutableLiveData<Boolean>()
    internal val errorMessage = MutableLiveData<String>()
    internal val consolidatedResponse = MutableLiveData<ArrayList<ConsolidatedResponse>>()
    internal val searchResponse = MutableLiveData<ArrayList<SearchResponse>>()
    internal var locationTitle: String = ""

    fun getToday() {
        job = viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getLocationDay(44418, currentTime)
            d("aaa", "$date")
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    consolidatedResponse.postValue(response.body())
                    loading.value = false
                    d("XXX", "viewmodel :${response.body()}")
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }

    fun getSearchLocation() {
        job = viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getLocationSearch(locationTitle)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    //todayList.postValue(response.body() as ArrayList<ConsolidatedResponse>?)
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}