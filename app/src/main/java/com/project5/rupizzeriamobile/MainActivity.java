package com.project5.rupizzeriamobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static ArrayList<Pizza> pizzas = new ArrayList<>();

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
            Intent intent = new Intent(MainActivity.this, CurrentOrdersActivity.class);
            startActivity(intent);
        });

        Button storeOrdersBTN = findViewById(R.id.storeOrdersBTN);
        storeOrdersBTN.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intent);
        });

    }
}