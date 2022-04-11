package com.example.myapplication.ui.base

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.remote.ApiClient
import com.example.myapplication.data.repository.Repository
import com.example.myapplication.data.response.ConsolidatedResponse

@Suppress("DEPRECATION")
abstract class BaseFragment : Fragment() {

    private lateinit var viewModel: BaseViewModel
    private var todayResponse = mutableListOf<ConsolidatedResponse>()

    /**
     * This function is used to define subscript ion
     */
    abstract fun onBindViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val retrofitService = ApiClient.getApiService()
        Log.d("log api: ", "${ApiClient.getApiService()}")
        val mainRepository = Repository(retrofitService)
        viewModel = ViewModelProvider(
            this, BaseViewModelFactory(mainRepository)
        )[BaseViewModel::class.java]
        viewModel.consolidatedResponse.observe(this, {
            todayResponse.clear()
            todayResponse.addAll(it)
            Log.d("XXX", "đê $todayResponse")
        })
        viewModel.errorMessage.observe(this, {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
        viewModel.getToday()
        Log.d("XXX", "dodo $todayResponse")
    }

    internal fun getData() = todayResponse
}