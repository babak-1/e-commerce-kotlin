package com.babak.ecommerceproject.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        val retrofit=Retrofit.Builder().baseUrl("https://api.escuelajs.co/").addConverterFactory(GsonConverterFactory.create()).build()
    }
}