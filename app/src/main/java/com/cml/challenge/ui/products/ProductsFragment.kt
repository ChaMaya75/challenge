package com.cml.challenge.ui.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.cml.challenge.R
import com.cml.challenge.databinding.FragmentProductsBinding
import com.cml.challenge.databinding.FragmentSearchBinding
import com.cml.challenge.ui.search.SearchViewModel


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

        return binding.root
    }
}