package com.cml.challenge.app.ui.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cml.challenge.R
import com.cml.challenge.core.model.ProductModel

class ProductAdapter (val items:List<ProductModel>): RecyclerView.Adapter<ProductViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        return ProductViewHolder(
            layoutInflater.inflate(
                R.layout.item_product,
                parent,
                false
            ), mListener
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item: ProductModel = items[position]
        holder.bind(item)
    }

}