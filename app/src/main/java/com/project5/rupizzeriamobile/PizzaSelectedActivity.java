package com.project5.rupizzeriamobile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PizzaSelectedActivity extends AppCompatActivity {

    private RecyclerView menuScroll;
    private RecyclerView.LayoutManager pizzaLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);



    }
}
