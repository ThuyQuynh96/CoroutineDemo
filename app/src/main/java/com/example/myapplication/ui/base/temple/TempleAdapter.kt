package com.example.myapplication.ui.base.temple

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ui.base.getString
import com.example.myapplication.databinding.ItemDayBinding
import com.example.myapplication.type.DayType

class TempleAdapter(private val items: MutableList<DayType>) :
    RecyclerView.Adapter<TempleAdapter.TempleVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempleVH {
        return TempleVH(ItemDayBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TempleVH, position: Int) {
        holder.binding(position)
    }

    override fun getItemCount(): Int = items.size

    inner class TempleVH(private val viewBinding: ItemDayBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun binding(position: Int) {
            viewBinding.apply {
                items[position].let {
                    if (it.titleResource != -1) {
                        tvNameDay.text = getString(it.titleResource)
                    }
                    if (it.iconResource != -1) {
                        imgIcon.setImageResource(it.iconResource)
                    }
                    if (it.tempMorninng != -1) {
                        tvMaxTemp.text = getString(it.tempMorninng)
                    }
                    if (it.tempEvening != -1) {
                        tvMinTemp.text = getString(it.tempEvening)
                    }
                    vView.visibility = View.VISIBLE
                }
            }
        }
    }


}