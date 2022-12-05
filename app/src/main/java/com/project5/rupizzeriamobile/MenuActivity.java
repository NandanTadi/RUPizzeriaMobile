package com.project5.rupizzeriamobile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView menuScroll;
    private ArrayList<Pizza> pizzas = new ArrayList<>();
    private RecyclerView.LayoutManager pizzaLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        PizzaFactory chicago = new ChicagoPizza();
        PizzaFactory ny = new NYPizza();
        pizzas.add(chicago.createDeluxe());
        pizzas.add(chicago.createBBQChicken());
        pizzas.add(chicago.createMeatzza());
        pizzas.add(chicago.createBuildYourOwn());
        pizzas.add(ny.createDeluxe());
        pizzas.add(ny.createBBQChicken());
        pizzas.add(ny.createMeatzza());
        pizzas.add(ny.createBuildYourOwn());
        menuScroll = findViewById(R.id.menuScroll);
        menuScroll.findViewById(R.id.menuScroll);
        menuScroll.setHasFixedSize(true);
        PizzaAdapter adapter = new PizzaAdapter(this,pizzas);
        menuScroll.setLayoutManager(new LinearLayoutManager(this));
        menuScroll.setAdapter(adapter);


    }
}
