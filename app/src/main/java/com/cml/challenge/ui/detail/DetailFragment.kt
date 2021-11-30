package com.cml.challenge.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cml.challenge.databinding.FragmentDetailBinding
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.core.parameter.parametersOf

class DetailFragment : Fragment() {

    private val detailFragmentViewModel: DetailViewModel by lifecycleScope.viewModel(this){
        parametersOf(arguments?.get("idProduct").toString())
    }

    private lateinit var binding : FragmentDetailBinding
    private lateinit var adapter: DetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentDetailBinding.inflate(inflater,container,false)

        detailFragmentViewModel.detail.observe(viewLifecycleOwner, Observer {
            adapter = DetailAdapter(it)
            binding.rvDetail.adapter = adapter
        })

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detailViewModel = detailFragmentViewModel


        initRecycleView()
    }

    private fun initRecycleView() {
        adapter = DetailAdapter(null)
        binding.rvDetail.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        binding.rvDetail.adapter = adapter
    }
}