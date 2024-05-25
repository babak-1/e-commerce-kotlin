package com.babak.ecommerceproject.api

import retrofit2.create

class ApiClient {
    companion object{
        fun createApi():ApiServer{
            return RetrofitClient.retrofit.create(ApiServer::class.java)
        }
    }
}