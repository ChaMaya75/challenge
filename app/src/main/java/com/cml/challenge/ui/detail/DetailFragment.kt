package com.cml.challenge.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cml.challenge.R
import com.cml.challenge.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding : FragmentDetailBinding
    private lateinit var idProduct : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentDetailBinding.inflate(inflater,container,false)

        idProduct = arguments?.get("idProduct").toString()

        binding.rvDetail.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)

        Toast.makeText(activity,"Item: $idProduct",Toast.LENGTH_LONG).show()
        return binding.root
    }

}