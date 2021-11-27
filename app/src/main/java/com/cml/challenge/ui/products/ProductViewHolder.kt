package com.cml.challenge.ui.products

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cml.challenge.data.network.ItemSearch
import com.cml.challenge.databinding.ItemProductBinding
import com.squareup.picasso.Picasso
import java.net.URL
import java.text.NumberFormat
import java.util.*

class ProductViewHolder (view:View,listener:ProductAdapter.onItemClickListener):RecyclerView.ViewHolder(view){
    private val binding = ItemProductBinding.bind(view)
    fun bind(item:ItemSearch){

        binding.tvTitulo.text = item.title
        val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale.US)
        binding.tvPrecio.text = format.format(item.price)
        //Picasso.get().load(item.thumbnail).into(binding.imageProduct)
        val oldUrl = URL(item.thumbnail)
        val newUrl =
            URL("https", oldUrl.getHost(), oldUrl.getPort(), oldUrl.getFile())
        Log.i("***", newUrl.path)
        Picasso.get().load(newUrl.toExternalForm()).into(binding.imageProduct)
    }
    init {
        itemView.setOnClickListener {
            listener.onItemClick(adapterPosition)
        }
    }
}