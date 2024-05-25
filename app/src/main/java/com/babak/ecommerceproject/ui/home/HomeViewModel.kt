package com.babak.ecommerceproject.ui.home

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

    private val _allProducts = MutableLiveData<ProductsResponse>()
    val allProducts: LiveData<ProductsResponse> = _allProducts

    fun requestAllProducts() {
        viewModelScope.launch(Dispatchers.IO) {

            try {
                val response=repo.getAllCards()
                if(response.isSuccessful){
                    response.body()?.let {
                        withContext(Dispatchers.Main){
                            _allProducts.value=it
                        }
                    }

                }
            }catch (e:Exception){

            }
        }
    }
}