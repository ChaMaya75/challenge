package com.cml.challenge.ui.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cml.challenge.data.network.ItemSearch
import com.cml.challenge.databinding.FragmentProductsBinding
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.core.parameter.parametersOf


class ProductsFragment : Fragment() {

    private val productViewModel: ProductViewModel by lifecycleScope.viewModel(this){
        parametersOf("xbox")
    }

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
        //productViewModel =
          //      ViewModelProvider(this).get(ProductViewModel::class.java)
        //productViewModel.query = arguments?.get("search").toString()

        binding = FragmentProductsBinding.inflate(inflater, container, false)

        productViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })
        productViewModel.productModel.observe(this, Observer {
            adapter = ProductAdapter(it)
            binding.rvProducts.adapter = adapter
            adapter.setOnItemClickListener(object : ProductAdapter.onItemClickListener{
                override fun onItemClick(position: Int) {

                    Toast.makeText(activity,"Item: ${adapter.items[position].title}",Toast.LENGTH_LONG).show()
                }

            })
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
        adapter.setOnItemClickListener(object : ProductAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                Toast.makeText(activity,"Item: ${adapter.items[position].title}",Toast.LENGTH_LONG).show()
            }

        })
    }
}