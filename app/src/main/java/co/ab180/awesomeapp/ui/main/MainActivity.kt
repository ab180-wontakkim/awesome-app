package co.ab180.awesomeapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.ab180.awesomeapp.R
import co.ab180.awesomeapp.domain.model.Product
import co.ab180.awesomeapp.network.ApiService
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = ProductsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initContents()
    }

    private fun initContents() {
        val products = ApiService.getProducts(this)
        adapter.submitList(products)
        recyclerView.adapter = adapter
    }
}
