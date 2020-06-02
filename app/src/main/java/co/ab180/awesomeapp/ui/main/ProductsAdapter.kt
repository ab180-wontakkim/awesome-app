package co.ab180.awesomeapp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import co.ab180.airbridge.event.model.Product
import co.ab180.awesomeapp.R
import co.ab180.awesomeapp.domain.model.ProductInfo
import co.ab180.awesomeapp.ui.details.DetailsActivity
import com.squareup.picasso.Picasso

class ProductsAdapter : ListAdapter<ProductInfo, ProductViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val image = itemView.findViewById<ImageView>(R.id.image)
    private val nameLabel = itemView.findViewById<TextView>(R.id.nameLabel)
    private val priceLabel = itemView.findViewById<TextView>(R.id.priceLabel)

    private var target: ProductInfo? = null

    init {
        itemView.setOnClickListener {
            val context = itemView.context
            context.startActivity(DetailsActivity.createIntent(context, target!!))
        }
    }

    fun bind(product: ProductInfo) {
        target = product

        Picasso.get()
            .load(target!!.imageUrl)
            .into(image)
        nameLabel.text = target!!.name
        priceLabel.text = target!!.price
    }
}

class ProductDiffCallback : DiffUtil.ItemCallback<ProductInfo>() {

    override fun areItemsTheSame(oldItem: ProductInfo, newItem: ProductInfo): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ProductInfo, newItem: ProductInfo): Boolean {
        return oldItem.id == newItem.id
    }
}