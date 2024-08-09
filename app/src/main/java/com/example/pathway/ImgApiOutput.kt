package com.example.pathway

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("data") val data: List<VectorData>,
    @SerializedName("meta") val meta: Meta
)

data class VectorData(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String,
    @SerializedName("image") val image: Image,
    @SerializedName("licenses") val licenses: List<License>,
    @SerializedName("products") val products: List<Product>
)

data class Image(
    @SerializedName("source") val source: Source
)

data class Source(
    @SerializedName("url") val url: String
)

data class License(
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
)

data class Product(
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
)

data class Meta(
    @SerializedName("current_page") val currentPage: Int,
    @SerializedName("last_page") val lastPage: Int,
    @SerializedName("per_page") val perPage: Int,
    @SerializedName("total") val total: Int
)