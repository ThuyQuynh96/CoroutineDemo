package com.example.myapplication.ui.base.temple

import com.example.myapplication.data.response.ConsolidatedResponse
import com.example.myapplication.type.DayType
import java.util.*

interface TempleVMContract {
    fun getDayItems(): MutableList<DayType>

    fun getListDay(date: Date): List<ConsolidatedResponse>
}