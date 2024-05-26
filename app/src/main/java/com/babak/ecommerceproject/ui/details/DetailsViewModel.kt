package com.babak.ecommerceproject.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.babak.ecommerceproject.model.ProductsResponseItem
import com.babak.ecommerceproject.repo.ProductsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsViewModel : ViewModel() {
    val repo = ProductsRepo()


    private val _product = MutableLiveData<ProductsResponseItem>()
    val product: LiveData<ProductsResponseItem> = _product


    fun requestProduct(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repo.getCard(id)

                if (response.isSuccessful) {
                    response.body()?.let {
                            withContext(Dispatchers.Main) {
                                _product.value=it
                            }
                    }
                }

            } catch (e: Exception) {

            }
        }
    }

}