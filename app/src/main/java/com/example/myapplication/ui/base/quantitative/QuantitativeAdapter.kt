package com.example.myapplication.ui.base.quantitative

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.ui.base.getString
import com.example.myapplication.databinding.ItemQuantitativeBinding
import com.example.myapplication.type.ImageType
import com.example.myapplication.type.QuantitativeType

class QuantitativeAdapter(private var items: MutableList<QuantitativeType>) :
    RecyclerView.Adapter<QuantitativeAdapter.QuantitativeVH>() {

    internal var onClickListenItem: (position: Int) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuantitativeVH {
        return QuantitativeVH(
            ItemQuantitativeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: QuantitativeVH, position: Int) {
        holder.binding(position)
    }

    override fun getItemCount(): Int = items.size

    inner class QuantitativeVH(private val viewBinding: ItemQuantitativeBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        init {
            viewBinding.clItem.setOnClickListener {
                onClickListenItem.invoke(layoutPosition)
            }
        }

        fun binding(position: Int) {
            viewBinding.apply {
                items[position].let {
                    when (it.imageType) {
                        ImageType.GONE -> {
                            llTitle.visibility = View.VISIBLE
                            imgCompass.visibility = View.GONE
                            imgCompass.setImageResource(R.drawable.compass)
                        }
                        ImageType.VISIBLE -> {
                            llTitle.visibility = View.GONE
                            imgCompass.visibility = View.VISIBLE
                        }
                    }
                    if (it.titleResource != -1) {
                        tvTitle.text = getString(it.titleResource)
                    }
                    if (it.iconResource != -1) {
                        imgIcon.setImageResource(it.iconResource)
                    }
                    if (it.note != -1) {
                        tvNote.text = getString(it.note)
                    }
                    if (it.textType != -1) {
                        tvText.text = getString(it.textType)
                    }
                }
            }
        }
    }

}