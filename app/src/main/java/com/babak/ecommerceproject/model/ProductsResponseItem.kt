package com.babak.ecommerceproject.model


import com.google.gson.annotations.SerializedName

data class ProductsResponseItem(
    @SerializedName("category")
    val category: Category?,
    @SerializedName("creationAt")
    val creationAt: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("images")
    val images: List<String>?,
    @SerializedName("price")
    val price: Long?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?
)