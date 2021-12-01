package com.cml.challenge.ui.products

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cml.challenge.R
import com.cml.challenge.data.model.ProductModel
import com.cml.challenge.databinding.ItemProductBinding
import com.squareup.picasso.Picasso
import java.net.URL
import java.text.NumberFormat
import java.util.*

class ProductViewHolder (view:View,listener:ProductAdapter.onItemClickListener):RecyclerView.ViewHolder(view){

    private val binding = ItemProductBinding.bind(view)

    fun bind(item: ProductModel){

        binding.tvTitulo.text = item.title
        val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale.US)
        binding.tvPrecio.text = format.format(item.price)
        val oldUrl = URL(item.thumbnail)
        val newUrl =
            URL("https", oldUrl.getHost(), oldUrl.getPort(), oldUrl.getFile())
        Log.i("***", newUrl.path)

        val picasso : Picasso = Picasso.get()
        picasso.load(newUrl.toExternalForm())
                .placeholder(R.drawable.progress_animation)
                .into(binding.imageProduct)

    }
    init {
        itemView.setOnClickListener {
            listener.onItemClick(adapterPosition)
        }
    }
}