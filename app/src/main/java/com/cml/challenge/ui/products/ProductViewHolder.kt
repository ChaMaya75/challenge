package com.cml.challenge.ui.products

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cml.challenge.data.network.ItemSearch
import com.cml.challenge.databinding.ItemProductBinding
import com.squareup.picasso.Picasso
import java.net.URL

class ProductViewHolder (view:View):RecyclerView.ViewHolder(view){
    private val binding = ItemProductBinding.bind(view)
    fun bind(item:ItemSearch){
        Log.i("***", item.thumbnail)
        //Picasso.get().load(item.thumbnail).into(binding.imageProduct)
        val oldUrl = URL(item.thumbnail)
        val newUrl =
            URL("https", oldUrl.getHost(), oldUrl.getPort(), oldUrl.getFile())
        Log.i("***", newUrl.path)
        Picasso.get().load(newUrl.toExternalForm()).into(binding.imageProduct)
    }
}