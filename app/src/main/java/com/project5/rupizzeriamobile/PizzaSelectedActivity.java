package com.project5.rupizzeriamobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectedpizza_view);
        pizzaType = findViewById(R.id.pizzaType);
        totalLabel = findViewById(R.id.totalLabel);
        sizeSpinner = findViewById(R.id.sizeSpinner);
        atcBTN = findViewById(R.id.atcBtn);
        Intent intent = getIntent();
        pizzaType.setText(intent.getStringExtra("ITEM"));
        ArrayAdapter<Size> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        sizeSpinner.setAdapter(adapter);
    }

    // need to do add to cart functionality
}
