package com.example.myapplication.ui.base.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.response.ConsolidatedResponse
import com.example.myapplication.data.response.ParentResponse
import com.example.myapplication.databinding.ItemAddBinding
import com.example.myapplication.databinding.ItemLocationWeatherBinding
import com.example.myapplication.ui.base.getString

class SearchAdapter(
    private var listItem: List<ParentResponse>,
    private var todayResponse: ConsolidatedResponse
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val HEADER = 0
    }

    internal var onClickItemListener: (position: Int) -> Unit = {}
    internal var onClickAddListener: () -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER -> ItemViewHolder(
                ItemLocationWeatherBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            else -> AddViewHolder(
                ItemAddBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ItemViewHolder)?.binding(position)
        (holder as? AddViewHolder)
    }

    override fun getItemCount(): Int = listItem.size

    inner class ItemViewHolder(private val viewBinding: ItemLocationWeatherBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        init {
            viewBinding.clItem.setOnClickListener {
                onClickItemListener.invoke(layoutPosition)
            }
        }

        fun binding(position: Int) {
            viewBinding.apply {
                if (listItem[0].location) {
                    tvCity.text = getString(R.string.text_location)
                    tvLocation.text = listItem[0].title
                    tvLocation.visibility = View.VISIBLE
                } else {
                    listItem[position].apply {
                        tvWeath.text = woeid.toString()
                    }
                }
                todayResponse.apply {
                    tvTemple.text = ((min_temp.toInt() + max_temp.toInt()) / 2).toString()
                    tvMin.text = min_temp.toString()
                    tvMax.text = max_temp.toString()
                }
            }
        }
    }

    inner class AddViewHolder(private val viewBinding: ItemAddBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        init {
            viewBinding.imgAdd.setOnClickListener {
                onClickAddListener.invoke()
            }
        }
    }
}