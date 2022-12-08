package com.project5.rupizzeriamobile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class CurrentOrdersActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listview;
    private ArrayAdapter<Object> adapter;
    private int id = 0;


    /**
     * Initial setup for the Views and the adapter for the ListView
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_activity);
        adapter = new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1,
                MainActivity.pizzas.getCurrentOrder().stream().map(x -> x.toString("")).collect(Collectors.toList()));
        listview = findViewById(R.id.current_order_list);
        listview.setOnItemClickListener(this); //register the listener for an OnItemClick event.
        listview.setAdapter(adapter);

        Button placeOrderBTN = findViewById(R.id.place_order_button);
        placeOrderBTN.setOnClickListener(v -> {
            if(MainActivity.pizzas.getCurrentOrder().size() > 0){
                Order current = new Order(MainActivity.pizzas);
                current.setOrderNumber(id);
                current.setPrice(updatePricing());
                MainActivity.storeOrder.add(current);
                id++;
                MainActivity.pizzas = new Order();
            }
            Intent intent = new Intent(CurrentOrdersActivity.this, StoreOrdersActivity.class);
            startActivity(intent);

        });

        Button clearOrdersBTN = findViewById(R.id.clear_order);
        clearOrdersBTN.setOnClickListener(v -> {
            MainActivity.pizzas.getCurrentOrder().clear();
            Intent intent = new Intent(CurrentOrdersActivity.this, MainActivity.class);
            startActivity(intent);
        });


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Would you like to remove this pizza?");
        alert.setMessage(adapterView.getAdapter().getItem(i).toString());
        //anonymous inner class to handle the onClick event of YES or NO.
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.pizzas.getCurrentOrder().remove(i);
                Toast.makeText(getApplicationContext(), "Successfully Removed!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CurrentOrdersActivity.this, CurrentOrdersActivity.class);
                startActivity(intent);
            }
        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Pizza Was Not Removed!", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    /**
     * Updates the current pricing for all elements in order so
     * that order sums are properly updated.
     */
    private double updatePricing() {
        double subtotal = 0.00;
        for(Pizza i: MainActivity.pizzas.getCurrentOrder()) {
            subtotal += i.price();
        }
        double tax = subtotal * 0.06625;

        double total = subtotal + tax;
        return total;
    }


}
