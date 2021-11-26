package com.cml.challenge.ui.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cml.challenge.databinding.FragmentProductsBinding


class ProductsFragment : Fragment() {

    private lateinit var productViewModel: ProductViewModel

    private lateinit var binding: FragmentProductsBinding

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

        productViewModel.onCreate("xbox360")
        return binding.root
    }
}