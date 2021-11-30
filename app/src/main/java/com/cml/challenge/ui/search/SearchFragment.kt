package com.cml.challenge.ui.search

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
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
        if(searchViewModel.isEmptySearch()){
            binding.editTextTextSearch.error = getString(R.string.required)
            return
        }
        if(Utilities.isNetworkAvailable(this.context)) {
            val args = Bundle()
            args.putString("search", binding.editTextTextSearch.text.toString())
            Navigation.findNavController(binding.root).navigate(R.id.action_nav_search_to_productsFragment,args)
        }else{
        }
        val inputMethodManager = activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchviewmodel = searchViewModel
    }
}