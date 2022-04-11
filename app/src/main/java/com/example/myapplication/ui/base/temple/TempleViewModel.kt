package com.example.myapplication.ui.base.temple

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.data.remote.ApiClient
import com.example.myapplication.data.repository.Repository
import com.example.myapplication.data.response.ConsolidatedResponse
import com.example.myapplication.type.DayType
import com.example.myapplication.ui.base.BaseViewModel
import com.example.myapplication.ui.base.BaseViewModelFactory
import java.util.*

class TempleViewModel : TempleVMContract {

    private val listDay: List<ConsolidatedResponse>? = null
    private val items: MutableList<DayType> = mutableListOf(
        DayType(
            titleResource = R.string.thu2,
            iconResource = R.drawable.icon1,
            tempMorninng = R.string.tem19,
            tempEvening = R.string.tem15
        ),
        DayType(
            titleResource = R.string.thu3,
            iconResource = R.drawable.icon2,
            tempMorninng = R.string.tem19,
            tempEvening = R.string.tem15
        ),
        DayType(
            titleResource = R.string.thu4,
            iconResource = R.drawable.icon3,
            tempMorninng = R.string.tem19,
            tempEvening = R.string.tem15
        ),
        DayType(
            titleResource = R.string.thu5,
            iconResource = R.drawable.icon4,
            tempMorninng = R.string.tem19,
            tempEvening = R.string.tem15
        ),
        DayType(
            titleResource = R.string.thu6,
            iconResource = R.drawable.icon5,
            tempMorninng = R.string.tem19,
            tempEvening = R.string.tem15
        ),
        DayType(
            titleResource = R.string.thu7,
            iconResource = R.drawable.icon6,
            tempMorninng = R.string.tem19,
            tempEvening = R.string.tem15
        ),
        DayType(
            titleResource = R.string.cn,
            iconResource = R.drawable.icon7,
            tempMorninng = R.string.tem19,
            tempEvening = R.string.tem15
        )
    )

    override fun getDayItems(): MutableList<DayType> = items

    override fun getListDay(date: Date): List<ConsolidatedResponse> =listDay ?: listOf()
}

//private fun initData() {
//    val retrofitService = ApiClient.getApiService()
//    Log.d("log api: ", "${ApiClient.getApiService()}")
//    val mainRepository = Repository(retrofitService)
//    viewModel = ViewModelProvider(
//        this, BaseViewModelFactory(mainRepository)
//    )[BaseViewModel::class.java]
//    viewModel.consolidatedResponse.observe(viewLifecycleOwner, {
//        todayResponse.clear()
//        todayResponse.addAll(it)
//        Log.d("XXX", "đê $todayResponse")
//    })
//    viewModel.errorMessage.observe(viewLifecycleOwner, {
//        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
//    })
//    viewModel.getToday()
//}