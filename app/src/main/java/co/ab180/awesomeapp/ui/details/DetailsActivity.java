package co.ab180.awesomeapp.ui.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import co.ab180.airbridge.Airbridge;
import co.ab180.airbridge.event.ecommerce.ProductDetailsViewEvent;
import co.ab180.airbridge.event.model.Product;
import co.ab180.awesomeapp.R;
import co.ab180.awesomeapp.domain.model.ProductInfo;

public class DetailsActivity extends AppCompatActivity {

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_IMAGE_URL = "imageUrl";
    private static final String KEY_PRICE = "price";

    private ImageView image;
    private TextView nameLabel;
    private TextView priceLabel;

    public static Intent createIntent(Context context, ProductInfo productInfo) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_ID, productInfo.getId());
        intent.putExtra(KEY_NAME, productInfo.getName());
        intent.putExtra(KEY_IMAGE_URL, productInfo.getImageUrl());
        intent.putExtra(KEY_PRICE, productInfo.getPrice());
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        nameLabel = findViewById(R.id.nameLabel);
        priceLabel = findViewById(R.id.priceLabel);
        image = findViewById(R.id.image);
        initContents();
    }

    private void initContents() {
        nameLabel.setText(getIntent().getStringExtra(KEY_NAME));
        Picasso.get()
                .load(getIntent().getStringExtra(KEY_IMAGE_URL))
                .into(image);
        priceLabel.setText(getIntent().getStringExtra(KEY_PRICE));
    }

    @Override
    protected void onResume() {
        super.onResume();
        sendEvent();
    }

    private void sendEvent() {
        List<Product> products = new ArrayList<Product>();
        Product product = new Product(
                getIntent().getStringExtra(KEY_ID),
                getIntent().getStringExtra(KEY_NAME),
                null,
                null,
                null,
                null
        );
        products.add(product);
        ProductDetailsViewEvent event = new ProductDetailsViewEvent(products);
        Airbridge.trackEvent(event);
    }
}
