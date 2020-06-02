package co.ab180.awesomeapp.ui.main;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.ab180.airbridge.Airbridge;
import co.ab180.airbridge.event.ecommerce.HomeViewEvent;
import co.ab180.awesomeapp.R;
import co.ab180.awesomeapp.domain.model.Product;
import co.ab180.awesomeapp.network.ApiService;

public class MainActivity extends Activity {

    private ProductsAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ProductsAdapter();

        initContents();
    }

    @Override
    protected void onResume() {
        super.onResume();
        sendEvent();
    }

    private void initContents() {
        List<Product> products = ApiService.INSTANCE.getProducts(this);
        adapter.submitList(products);
        recyclerView.setAdapter(adapter);
    }

    private void sendEvent() {
        HomeViewEvent event = new HomeViewEvent();
        Airbridge.trackEvent(event);
    }
}
