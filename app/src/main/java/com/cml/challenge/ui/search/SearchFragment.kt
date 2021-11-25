package com.cml.challenge.ui.search

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.cml.challenge.R
import com.cml.challenge.utilities.Utilities

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel
    private lateinit var root : View

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        searchViewModel =
                ViewModelProvider(this).get(SearchViewModel::class.java)
        root = inflater.inflate(R.layout.fragment_search, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        searchViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        val buttonSearch : Button = root.findViewById(R.id.button_search)
        buttonSearch.setOnClickListener { onSearch()}
        return root
    }
    private fun onSearch() {
        val searchText : EditText = root.findViewById(R.id.editTextText_Search)
        if(Utilities.isNetworkAvailable(this.context)) {
            Toast.makeText(requireContext(), "Si hay internet", Toast.LENGTH_LONG).show()
            root.findNavController().navigate(R.id.action_nav_search_to_productsFragment)
        }else{
            Toast.makeText(requireContext(), "No hay internet", Toast.LENGTH_LONG).show()
        }
    }
}