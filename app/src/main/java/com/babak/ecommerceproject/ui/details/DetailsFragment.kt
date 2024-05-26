package com.babak.ecommerceproject.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.babak.ecommerceproject.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
    var _binding: FragmentDetailsBinding? = null
    val binding get() = _binding!!
    private val args:DetailsFragmentArgs by navArgs()
    private val viewModel: DetailsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = args.id.toString()
        observData(id)
    }

    fun observData(id:String){
        viewModel.product.observe(viewLifecycleOwner, Observer { product->
            viewModel.requestProduct(id)
        })
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}