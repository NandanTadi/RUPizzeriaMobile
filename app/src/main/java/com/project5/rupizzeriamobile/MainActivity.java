package com.project5.rupizzeriamobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * MainActivity class to provide functionality and interactive directions for main tab on the app
 * @author Santosh Maryala, Nandan Tadi
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static Order pizzas = new Order();
    public static StoreOrder storeOrder = new StoreOrder();
    public static HashMap<Integer, Order> orders = new HashMap<>();

    /**
     * Initial setup for the Views and the adapter for the RecyclerView
     * Initializes multiple onclicks for buttons to direct users to different tab
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button menuBTN = findViewById(R.id.menuBTN);
        menuBTN.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intent);
        });
        Button currentOrdersBTN = findViewById(R.id.currentOrdersBTN);
        currentOrdersBTN.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,
                    CurrentOrdersActivity.class);
            startActivity(intent);
        });
        Button storeOrdersBTN = findViewById(R.id.storeOrdersBTN);
        storeOrdersBTN.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StoreOrdersActivity.class);
            startActivity(intent);
        });
    }
}