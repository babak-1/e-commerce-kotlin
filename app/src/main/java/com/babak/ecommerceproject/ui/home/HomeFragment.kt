package com.babak.ecommerceproject.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.babak.ecommerceproject.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    var _binding:FragmentHomeBinding?=null
    val binding get() = _binding!!
    var adapter=HomeAdapter()
    val viewModel by viewModels<HomeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvHome.adapter=adapter
        observedData()
        viewModel.requestAllProducts()
        adapter.onClickProduct={
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(it))
        }

    }
    fun observedData(){
        viewModel.allProducts.observe(viewLifecycleOwner){
        adapter.updateList(it.products)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}