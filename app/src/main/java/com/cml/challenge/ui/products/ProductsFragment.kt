package com.cml.challenge.ui.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cml.challenge.data.network.ItemSearch
import com.cml.challenge.databinding.FragmentProductsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher


class ProductsFragment : Fragment() {

    private lateinit var productViewModel: ProductViewModel

    private lateinit var binding: FragmentProductsBinding

    private lateinit var adapter: ProductAdapter
    private val itemsProducts = mutableListOf<ItemSearch>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        productViewModel =
                ViewModelProvider(this).get(ProductViewModel::class.java)

        binding = FragmentProductsBinding.inflate(inflater, container, false)

        productViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.productviewmodel = productViewModel
        initRecycleView()
    }

    private fun initRecycleView() {
        adapter = ProductAdapter(itemsProducts)
        binding.rvProducts.layoutManager = LinearLayoutManager(this.context)
        binding.rvProducts.adapter = adapter
        searchProduct("")
    }
    private fun searchProduct(query:String){
        itemsProducts.clear()
        CoroutineScope(Dispatchers.IO).launch {
            val productos : List<ItemSearch> = productViewModel.search("xbox360")
            itemsProducts.addAll(productos)
            activity?.runOnUiThread {
                adapter.notifyDataSetChanged()
            }
        }

    }
}