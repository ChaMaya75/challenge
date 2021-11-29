package com.cml.challenge.ui.detail

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cml.challenge.data.network.ItemSearch

import com.cml.challenge.databinding.ItemDetailBinding
import com.squareup.picasso.Picasso
import java.net.URL


class DetailViewHolder (view:View):RecyclerView.ViewHolder(view){

    private val binding = ItemDetailBinding.bind(view)

    fun bind(image: String){
        val oldUrl = URL(image)
        val newUrl =
                URL("https", oldUrl.getHost(), oldUrl.getPort(), oldUrl.getFile())
        Log.i("***", newUrl.path)
        Picasso.get().load(newUrl.toExternalForm()).into(binding.imageDetail)
    }

}