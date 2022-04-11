package com.example.myapplication.ui.base.quantitative

import com.example.myapplication.type.QuantitativeType

interface QuantitativeVMContact {
    fun getQuantitativeItems(): MutableList<QuantitativeType>
}