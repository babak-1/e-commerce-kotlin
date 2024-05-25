package com.babak.ecommerceproject.repo

import com.babak.ecommerceproject.api.ApiClient
import com.babak.ecommerceproject.model.ProductsResponse
import retrofit2.Response

class ProductsRepo {
    private val api =ApiClient.createApi()
    suspend fun getAllCards():Response<ProductsResponse>{
     return api.getAllProducts()
    }
}