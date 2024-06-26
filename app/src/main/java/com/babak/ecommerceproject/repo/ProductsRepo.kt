package com.babak.ecommerceproject.repo

import androidx.navigation.fragment.navArgs
import com.babak.ecommerceproject.api.ApiClient
import com.babak.ecommerceproject.model.ProductsResponse
import com.babak.ecommerceproject.model.ProductsResponseItem
import com.babak.ecommerceproject.ui.details.DetailsFragmentArgs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductsRepo {



    private val api =ApiClient.createApi()
    suspend fun getAllCards():Response<List<ProductsResponseItem>> = withContext(Dispatchers.IO){
     return@withContext api.getAllProducts()
    }

    suspend fun getCard(id:String):Response<ProductsResponseItem>{
        return api.getProduct(id)
    }
}