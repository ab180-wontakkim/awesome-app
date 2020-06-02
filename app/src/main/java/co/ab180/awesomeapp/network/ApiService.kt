package co.ab180.awesomeapp.network

import android.content.Context
import co.ab180.awesomeapp.domain.model.ProductInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ApiService {

    fun getProducts(context: Context): List<ProductInfo> {
        val jsonString = context.assets.open("products.json")
            .bufferedReader().use { it.readText() }
        val type = object : TypeToken<List<ProductInfo>>() {}.type
        return Gson().fromJson(jsonString, type)
    }
}