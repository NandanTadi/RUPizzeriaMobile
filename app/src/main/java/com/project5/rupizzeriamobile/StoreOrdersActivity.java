package com.project5.rupizzeriamobile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

/**
 * StoreOrderActivity class to provide functionality for store orders tab
 * @author Santosh Maryala, Nandan Tadi
 */

public class StoreOrdersActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView listview;
    private ArrayAdapter<Object> adapter;
    private TextView number_orders_total;
    private TextView order_total_value;
    private DecimalFormat df = new DecimalFormat("#.##");

    /**
     * Initial setup for the Views and the adapter for the ListView
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_activity);
        adapter = new ArrayAdapter<Object>((Context) this, android.R.layout.simple_list_item_1,
                MainActivity.storeOrder.storeOrders.toArray());
        listview = findViewById(R.id.store_order_list);
        listview.setOnItemClickListener(this); //register the listener for an OnItemClick event.
        listview.setAdapter(adapter);
        number_orders_total = findViewById(R.id.number_orders_value);
        order_total_value = findViewById(R.id.order_total_value);
        displayLabels();
    }

    /**
     * On item click function where it directs specific alerts based on if
     * user wants to delete the order
     * @param adapterView AdapterView
     * @param view View
     * @param i current index of the selected pizza
     * @param l long value
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Would you like to remove this order?");
        alert.setMessage(adapterView.getAdapter().getItem(i).toString());
        //anonymous inner class to handle the onClick event of YES or NO.
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.storeOrder.storeOrders.remove(i);
                displayLabels();
                Toast.makeText(getApplicationContext(), "Order successfully removed!",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(StoreOrdersActivity.this,
                        MainActivity.class);
                startActivity(intent);
            }
        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Order was not removed!",
                        Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    /**
     * Method to display the total orders # and total order value labels
     */
    public void displayLabels(){
        int totalOrders = MainActivity.storeOrder.storeOrders.size();
        number_orders_total.setText("" + totalOrders);
        double finalPrice = MainActivity.storeOrder.getTotalPrice();
        order_total_value.setText(df.format(finalPrice));
    }
}
