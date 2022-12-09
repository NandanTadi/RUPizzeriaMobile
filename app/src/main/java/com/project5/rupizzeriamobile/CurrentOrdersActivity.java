package com.project5.rupizzeriamobile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * CurrentOrderActivity class to provide functionality for current orders tab
 * @author Santosh Maryala, Nandan Tadi
 */
public class CurrentOrdersActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView listview;
    private ArrayAdapter<Object> adapter;
    private TextView subtotal_value;
    private TextView tax_value;
    private TextView total_value;
    private static double TAX_VALUE = 0.06625;
    private DecimalFormat df = new DecimalFormat("#.##");

    /**
     * Initial setup for the Views and the adapter for the ListView
     * Checks if the current order list contains pizzas and if so display order details
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_activity);
        adapter = new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1,
                MainActivity.pizzas.getCurrentOrder().stream().map(x -> x.toString(""))
                                .collect(Collectors.toList()));
        listview = findViewById(R.id.current_order_list);
        listview.setOnItemClickListener(this); //register the listener for an OnItemClick event.
        listview.setAdapter(adapter);
        subtotal_value = findViewById(R.id.subtotal_value);
        tax_value = findViewById(R.id.tax_value);
        total_value = findViewById(R.id.total_value);
        Button placeOrderBTN = findViewById(R.id.place_order_button);
        updatePricing();
        placeOrderBTN.setOnClickListener(v -> {
            if(MainActivity.pizzas.getCurrentOrder().size() > 0){
                Order current = new Order(MainActivity.pizzas);
                current.setPrice(updatePricing());
                MainActivity.storeOrder.add(current);
                MainActivity.pizzas = new Order();
                Intent intent = new Intent(CurrentOrdersActivity.this,
                        StoreOrdersActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(), "Cart is empty!", Toast.LENGTH_LONG)
                        .show();
            }
        });
        Button clearOrdersBTN = findViewById(R.id.clear_order);
        clearOrdersBTN.setOnClickListener(v -> {
            MainActivity.pizzas.getCurrentOrder().clear();
            Intent intent = new Intent(CurrentOrdersActivity.this, MainActivity
                    .class);
            startActivity(intent);
        });
    }

    /**
     * On item click function where it directs specific alerts and toasts based on if
     * user wants to delete the pizza
     * @param adapterView AdapterView
     * @param view View
     * @param i current index of the selected pizza
     * @param l long value
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Would you like to remove this pizza?");
        alert.setMessage(adapterView.getAdapter().getItem(i).toString());
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.pizzas.getCurrentOrder().remove(i);
                Toast.makeText(getApplicationContext(), "Pizza successfully removed!", Toast
                        .LENGTH_LONG).show();
                updatePricing();
                Intent intent = new Intent(CurrentOrdersActivity.this, MainActivity
                        .class);
                startActivity(intent);
            }
        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Pizza was not removed!", Toast
                        .LENGTH_LONG).show();
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
        subtotal_value.setText("" + df.format(subtotal));
        double tax = subtotal * TAX_VALUE;
        tax_value.setText("" + df.format(tax));
        double total = subtotal + tax;
        total_value.setText("" + df.format(total));
        return total;
    }
}
