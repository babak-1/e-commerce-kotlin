package com.babak.ecommerceproject.api

import com.babak.ecommerceproject.model.ProductsResponse
import com.babak.ecommerceproject.model.ProductsResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServer {
    @GET("api/v1/products")
    suspend fun getAllProducts():Response<ProductsResponse>

    @GET("api/v1/products")
    suspend fun getProduct(@Path("id")id:String):Response<ProductsResponseItem>
}