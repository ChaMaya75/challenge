package com.cml.challenge.ui.detail

import android.view.View
import androidx.recyclerview.widget.RecyclerView


class DetailViewHolder(view: View) : RecyclerView.ViewHolder (view) {


    /*fun bind(item: String){

        binding.tvTitulo.text = item.title
        val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale.US)
        binding.tvPrecio.text = format.format(item.price)
        val oldUrl = URL(item.thumbnail)
        val newUrl =
                URL("https", oldUrl.getHost(), oldUrl.getPort(), oldUrl.getFile())
        Log.i("***", newUrl.path)
        Picasso.get().load(newUrl.toExternalForm()).into(binding.imageProduct)
    }*/
}