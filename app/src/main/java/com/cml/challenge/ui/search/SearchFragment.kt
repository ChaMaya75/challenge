package com.cml.challenge.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cml.challenge.R

class SearchFragment : Fragment() {

    private lateinit var homeViewModel: SearchViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(SearchViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_search, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        val buttonSearch : Button = root.findViewById(R.id.button_search)
        buttonSearch.setOnClickListener({ onSearch()})
        return root
    }
    private fun onSearch() {
        Toast.makeText(requireContext(), "Hola", Toast.LENGTH_LONG).show()
    }
}