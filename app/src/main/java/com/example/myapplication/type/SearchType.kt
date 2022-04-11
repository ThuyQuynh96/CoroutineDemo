package com.example.myapplication.type

import androidx.annotation.StringRes

class SearchType(
    @StringRes var titleResource: Int = -1,
    @StringRes var textResource: Int = -1,
    @StringRes var woed: Int = -1,
    @StringRes var maxTemp: Int = -1,
    @StringRes var minTemp: Int = -1,
    @StringRes var temple: Int = -1
)

enum class SearchVisible {
    GONE, VISIBLE
}