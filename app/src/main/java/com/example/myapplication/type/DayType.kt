package com.example.myapplication.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class DayType(
    @StringRes var titleResource: Int = -1,
    @DrawableRes var iconResource: Int = -1,
    @StringRes var tempMorninng: Int = -1,
    @StringRes var tempEvening: Int = -1
)
