package com.example.myapplication.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class QuantitativeType(
    @StringRes var titleResource: Int = -1,
    @DrawableRes var iconResource: Int = -1,
    @StringRes var note: Int = -1,
    @StringRes var textType: Int = -1,
    var imageType: ImageType = ImageType.GONE
)

enum class ImageType {
    GONE, VISIBLE
}