package co.ab180.awesomeapp.domain.model

import com.google.gson.annotations.SerializedName

data class ProductInfo(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("price")
    val price: String
)