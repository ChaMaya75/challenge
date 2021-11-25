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
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.cml.challenge.R
import com.cml.challenge.databinding.FragmentSearchBinding
import com.cml.challenge.utilities.Utilities

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        searchViewModel =
                ViewModelProvider(this).get(SearchViewModel::class.java)
        /*val root = inflater.inflate(R.layout.fragment_search, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        searchViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.buttonSearch.setOnClickListener{view: View->
            onSearch()
        }
        //val buttonSearch : Button = root.findViewById(R.id.button_search)
        //buttonSearch.setOnClickListener { onSearch()}
        return binding.root


    }
    private fun onSearch() {
        //val searchText : EditText = root.findViewById(R.id.editTextText_Search)
        if(searchViewModel.isEmptySearch()){
            binding.editTextTextSearch.error = getString(R.string.required)
            //Toast.makeText(requireContext(), "esta vacio", Toast.LENGTH_LONG).show()
            return
        }
        if(Utilities.isNetworkAvailable(this.context)) {
            //Toast.makeText(requireContext(), "Si hay internet", Toast.LENGTH_LONG).show()
            Navigation.findNavController(binding.root).navigate(R.id.action_nav_search_to_productsFragment)
        }else{
            //Toast.makeText(requireContext(), "No hay internet", Toast.LENGTH_LONG).show()
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchviewmodel = searchViewModel;
    }
}