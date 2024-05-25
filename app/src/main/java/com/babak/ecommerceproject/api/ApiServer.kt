package com.babak.ecommerceproject.api

import com.babak.ecommerceproject.model.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiServer {
    @GET("api/v1/products")
    suspend fun getAllProducts():Response<ProductsResponse>
}