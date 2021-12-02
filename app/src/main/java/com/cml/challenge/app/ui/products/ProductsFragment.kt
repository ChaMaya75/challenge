package com.cml.challenge.app.ui.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.cml.challenge.R
import com.cml.challenge.core.model.ProductModel
import com.cml.challenge.databinding.FragmentProductsBinding
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.core.parameter.parametersOf


class ProductsFragment : Fragment() {

    private val productViewModel: ProductViewModel by lifecycleScope.viewModel(this){
        parametersOf(arguments?.get("search").toString())
    }

    private lateinit var binding: FragmentProductsBinding

    private lateinit var adapter: ProductAdapter
    private val itemsProducts = mutableListOf<ProductModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProductsBinding.inflate(inflater, container, false)
        productViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.loading.isVisible = it
        })
        productViewModel.isEmpty.observe(viewLifecycleOwner, Observer {
            /*if(it)
                binding.tvEmpty.visibility = View.VISIBLE*/
            binding.tvEmpty.isVisible = it
        })
        productViewModel.productModel.observe(viewLifecycleOwner, Observer {
            adapter = ProductAdapter(it)
            binding.rvProducts.adapter = adapter
            adapter.setOnItemClickListener(object :
                ProductAdapter.onItemClickListener {
                override fun onItemClick(position: Int) {
                    //Toast.makeText(activity,"Item: ${adapter.items[position].title}",Toast.LENGTH_LONG).show()
                    val args = Bundle()
                    args.putString("idProduct", adapter.items[position].id)
                    Navigation.findNavController(binding.root).navigate(R.id.action_productsFragment_to_detailFragment,args)
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
    }
}