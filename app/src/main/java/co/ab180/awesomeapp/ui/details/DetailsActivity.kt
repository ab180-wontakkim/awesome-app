package co.ab180.awesomeapp.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.ab180.awesomeapp.R
import co.ab180.awesomeapp.domain.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        initContents()
    }

    private fun initContents() {
        nameLabel.text = intent.getStringExtra(KEY_NAME)
        Picasso.get()
            .load(intent.getStringExtra(KEY_IMAGE_URL))
            .into(image)
        priceLabel.text = intent.getStringExtra(KEY_PRICE)
    }

    companion object {

        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_IMAGE_URL = "imageUrl"
        private const val KEY_PRICE = "price"

        fun newIntent(context: Context, product: Product): Intent {
            return Intent(context, DetailsActivity::class.java).apply {
                putExtra(KEY_ID, product.id)
                putExtra(KEY_NAME, product.name)
                putExtra(KEY_IMAGE_URL, product.imageUrl)
                putExtra(KEY_PRICE, product.price)
            }
        }
    }
}