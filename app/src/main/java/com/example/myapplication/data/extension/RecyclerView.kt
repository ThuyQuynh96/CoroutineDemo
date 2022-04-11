package com.example.myapplication.ui.base

import androidx.recyclerview.widget.RecyclerView

internal fun RecyclerView.ViewHolder.getString(resourceId: Int): String =
    itemView.resources.getString(resourceId)

internal fun RecyclerView.ViewHolder.getString(resourceId: Int, text: String): String =
    itemView.resources.getString(resourceId, text)
