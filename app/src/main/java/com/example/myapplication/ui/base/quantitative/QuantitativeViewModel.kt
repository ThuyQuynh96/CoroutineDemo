package com.example.myapplication.ui.base.quantitative

import com.example.myapplication.R
import com.example.myapplication.type.ImageType
import com.example.myapplication.type.QuantitativeType

class QuantitativeViewModel : QuantitativeVMContact {

    private val quantitative: MutableList<QuantitativeType> = mutableListOf(
        QuantitativeType(
            titleResource = R.string.chi_so,
            iconResource = R.drawable.sunny,
            note = R.string.note_chi_so,
            textType = R.string.text_chi_so,
            imageType = ImageType.GONE
        ),
        QuantitativeType(
            titleResource = R.string.mat_troi,
            iconResource = R.drawable.sunny,
            note = R.string.note_mat_troi,
            textType = R.string.text_mat_troi,
            imageType = ImageType.GONE
        ),
        QuantitativeType(
            titleResource = R.string.gio,
            iconResource = R.drawable.wind,
            imageType = ImageType.VISIBLE
        ),
        QuantitativeType(
            titleResource = R.string.luong_mua,
            iconResource = R.drawable.rainy,
            note = R.string.note_lương_mua,
            textType = R.string.text_lương_mua,
            imageType = ImageType.GONE
        ),
        QuantitativeType(
            titleResource = R.string.do_am,
            iconResource = R.drawable.thermometer,
            note = R.string.note_do_am,
            textType = R.string.text_do_am,
            imageType = ImageType.GONE
        ),
        QuantitativeType(
            titleResource = R.string.ap_suat,
            iconResource = R.drawable.sunny,
            imageType = ImageType.VISIBLE
        )
    )

    override fun getQuantitativeItems(): MutableList<QuantitativeType> = quantitative
}