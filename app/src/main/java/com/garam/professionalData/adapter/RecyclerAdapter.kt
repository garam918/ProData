package com.garam.professionalData.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.garam.professionalData.R
import com.garam.professionalData.WebViewActivity
import com.garam.professionalData.data.ItemInfoData
import com.garam.professionalData.databinding.ItemLayoutBinding

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var items = ArrayList<ItemInfoData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(private val binding : ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemInfoData) {
            binding.item = item

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context,WebViewActivity::class.java)
                intent.putExtra("url",item.link)
                binding.root.context.startActivity(intent)
                (binding.root.context as Activity).overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right)
            }
        }
    }

}