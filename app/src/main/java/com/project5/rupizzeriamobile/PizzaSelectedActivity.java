package com.project5.rupizzeriamobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PizzaSelectedActivity extends AppCompatActivity {

    private RecyclerView menuScroll;
    private RecyclerView.LayoutManager pizzaLayout;
    private TextView pizzaType, totalLabel;
    private Spinner sizeSpinner;
    private Button atcBTN;
    private Size[] items = {Size.SMALL, Size.MEDIUM, Size.LARGE};
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectedpizza_view);
        pizzaType = findViewById(R.id.pizzaType);
        totalLabel = findViewById(R.id.totalLabel);
        sizeSpinner = findViewById(R.id.sizeSpinner);
        atcBTN = findViewById(R.id.atcBtn);
        addToCart(findViewById(R.id.atcBtn));
        System.out.println(intent);
        pizzaType.setText(intent.getStringExtra("ITEM"));
        ArrayAdapter<Size> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        sizeSpinner.setAdapter(adapter);
    }

    private void addToCart(@NonNull View itemView) {
        atcBTN.setOnClickListener(view -> {
            //Bundle args = intent.getBundleExtra("BUNDLE");
            //ArrayList<Pizza> options = (ArrayList<Pizza>) args.getSerializable("ARRAYLIST");
            int position = intent.getIntExtra("POSITION", 0);
            //Pizza cur = options.get(position);
            //cur.setSize(items[sizeSpinner.getSelectedItemPosition()]);
            //totalLabel.setText("$" + cur.price());
            //MainActivity.pizzas.add(cur);
            System.out.println(MainActivity.pizzas);
        });
    }


    }
