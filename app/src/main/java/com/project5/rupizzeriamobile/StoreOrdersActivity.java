package com.project5.rupizzeriamobile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

public class StoreOrdersActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listview;
    private ArrayAdapter<Object> adapter;

    /**
     * Initial setup for the Views and the adapter for the ListView
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_activity);
        adapter = new ArrayAdapter<Object>((Context) this, android.R.layout.simple_list_item_1, MainActivity.storeOrder.storeOrders.toArray());
        listview = findViewById(R.id.store_order_list);
        System.out.println(listview);
        listview.setOnItemClickListener(this); //register the listener for an OnItemClick event.
        listview.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        /*AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Would you like to remove this pizza?");
        alert.setMessage(adapterView.getAdapter().getItem(i).toString());
        //anonymous inner class to handle the onClick event of YES or NO.
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.pizzas.remove(i);
                System.out.println(MainActivity.pizzas);
                Toast.makeText(getApplicationContext(), "Successfully Removed!", Toast.LENGTH_LONG).show();
            }
        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Pizza Was Not Removed!", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();*/
    }
}
