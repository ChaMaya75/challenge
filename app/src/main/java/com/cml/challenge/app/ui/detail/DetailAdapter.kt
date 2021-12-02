package com.cml.challenge.app.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cml.challenge.R
import com.cml.challenge.core.model.DetailModel

class DetailAdapter(private val itemDetail: DetailModel?) : RecyclerView.Adapter<DetailViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        return DetailViewHolder(
            layoutInflater.inflate(
                R.layout.item_detail,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        if (itemDetail != null) {
            return itemDetail.pictures.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        if(itemDetail != null) {
            val item: String? = itemDetail.pictures[position].secure_url
            if (item != null) {
                holder.bind(item)
            }
        }
    }
}