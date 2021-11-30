package com.cml.challenge.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cml.challenge.R
import com.cml.challenge.data.network.APIResponseProduct

class DetailAdapter(private val itemDetail: APIResponseProduct?) : RecyclerView.Adapter<DetailViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        return DetailViewHolder(layoutInflater.inflate(R.layout.item_detail,parent,false))
    }

    override fun getItemCount(): Int {
        if (itemDetail != null) {
            return itemDetail.body.pictures.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        if(itemDetail != null) {
            val item: String? = itemDetail.body.pictures[position].secure_url
            if (item != null) {
                holder.bind(item)
            }
        }
    }
}