package com.garam.professionalData.util

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.garam.professionalData.adapter.RecyclerAdapter
import com.garam.professionalData.data.ItemInfoData

object DataBindingUtils {

    @BindingAdapter("itemList")
    @JvmStatic
    fun bindItem(recyclerView: RecyclerView, items: ObservableArrayList<ItemInfoData>) {
        if(recyclerView.adapter == null) {
            val lm = LinearLayoutManager(recyclerView.context)
            val adapter = RecyclerAdapter()
            recyclerView.layoutManager = lm
            recyclerView.adapter = adapter
        }
        (recyclerView.adapter as RecyclerAdapter).items = items
        recyclerView.adapter?.notifyDataSetChanged()
    }
}