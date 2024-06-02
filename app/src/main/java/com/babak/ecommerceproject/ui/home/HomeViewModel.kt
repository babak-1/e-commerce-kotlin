package com.babak.ecommerceproject.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.babak.ecommerceproject.model.ProductsResponse
import com.babak.ecommerceproject.model.ProductsResponseItem
import com.babak.ecommerceproject.repo.ProductsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {
    val repo = ProductsRepo()

    private val _allProducts = MutableLiveData<List<ProductsResponseItem>>()
    val allProducts: LiveData<List<ProductsResponseItem>> = _allProducts
    val error =MutableLiveData<String?>()

    init {
        requestAllProducts()
    }
   private fun requestAllProducts() {
        viewModelScope.launch {

            try {
                val response=repo.getAllCards()
                Log.e("responsum","${response.body()}")
                if(response.isSuccessful){

                    response.body()?.let {
                        withContext(Dispatchers.Main){
                            _allProducts.value=it
                        }
                    }

                }
            }catch (e:Exception){
                withContext(Dispatchers.Main){
                    error.value=e.localizedMessage
                    Log.e("xetam",e.localizedMessage)
                }

            }
        }
    }
}