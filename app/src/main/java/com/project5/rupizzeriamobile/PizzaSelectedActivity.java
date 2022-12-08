package com.project5.rupizzeriamobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PizzaSelectedActivity extends AppCompatActivity {

    private RecyclerView menuScroll;
    private RecyclerView.LayoutManager pizzaLayout;
    private TextView pizzaType, totalLabel, addTopCostLabel, totalPieCostLabel;
    private Spinner sizeSpinner;
    private Button atcBTN;
    private Size[] items = {Size.SMALL, Size.MEDIUM, Size.LARGE};
    private TableLayout toppingsGrid;
    private CheckBox[] toppingCB;
    private CheckBox chickenCB, pepperoniCB, hamCB, sausageCB, baconCB,
            mushroomsCB, onionsCB, jalapenoCB, cheddarCB, pineappleCB,
            provoloneCB, greenpepersCB, beefCB;
    private Intent intent;
    private Pizza cur;
    private static int FREEMAX = 7;
    private double extraCost = 0;
    private static double COST_PER_TOPPING = 1.59;
    private DecimalFormat df = new DecimalFormat("#.##");
    private static int disable = 2;
    private static int enable = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectedpizza_view);
        pizzaType = findViewById(R.id.pizzaType);
        totalLabel = findViewById(R.id.totalLabel);
        totalPieCostLabel = findViewById(R.id.totalPieCostLabel);
        addTopCostLabel = findViewById(R.id.addTopCostLabel);
        sizeSpinner = findViewById(R.id.sizeSpinner);
        atcBTN = findViewById(R.id.atcBtn);
        addToCart(findViewById(R.id.atcBtn));
        toppingsGrid = findViewById(R.id.toppingsGrid);
        toppingsGrid.setVisibility(View.INVISIBLE);
        pizzaType.setText(intent.getStringExtra("ITEM"));
        ArrayAdapter<Size> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        sizeSpinner.setAdapter(adapter);
        cur = (Pizza) intent.getSerializableExtra("PIZZA");
        cur.setSize(items[sizeSpinner.getSelectedItemPosition()]);
        totalLabel.setText("" + cur.price());
        totalPieCostLabel.setText("" + cur.price());
        if (cur instanceof BuildYourOwn) {
            setCBGroup();
        }
        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cur.setSize(items[sizeSpinner.getSelectedItemPosition()]);
                totalLabel.setText("" + cur.price());
                totalPieCostLabel.setText("" + cur.price());
                if (cur instanceof BuildYourOwn) {
                    cbClicked(findViewById(R.id.cheddarCB));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public double cbClicked(@NonNull View view) {
        int curToppings = iterateCBGroup(1).size();
        if (curToppings <= FREEMAX) {
            iterateCBGroup(3);
            extraCost = COST_PER_TOPPING * (curToppings);
            addTopCostLabel.setText(df.format(extraCost));
            totalPieCostLabel.setText(df.format(extraCost + cur.price()));
        }
        if (curToppings == FREEMAX){
            iterateCBGroup(2);
        }
        return extraCost;
    }
    private ArrayList<Topping> iterateCBGroup(int function) {
        ArrayList<Topping> selected = new ArrayList<>();
        for (CheckBox i: toppingCB) {
            if (function == 1 && i.isChecked()) {
                selected.add(Topping.valueOf(i.getText().toString().replace(" ",
                        "").toUpperCase()));
            } else if (function == disable && !i.isChecked()) {
                i.setEnabled(false);
            } else if (function == enable && !i.isChecked()) {
                i.setEnabled(true);
            }
        }
        return selected;
    }
    private void setCBGroup() {
        toppingsGrid.setVisibility(View.VISIBLE);
        chickenCB = findViewById(R.id.chickenCB);
        pepperoniCB = findViewById(R.id.pepperoniCB);
        hamCB = findViewById(R.id.hamCB);
        sausageCB = findViewById(R.id.sausageCB);
        pepperoniCB = findViewById(R.id.pepperoniCB);
        baconCB = findViewById(R.id.baconCB);
        mushroomsCB = findViewById(R.id.mushroomsCB);
        onionsCB = findViewById(R.id.onionsCB);
        jalapenoCB = findViewById(R.id.jalapenoCB);
        cheddarCB = findViewById(R.id.cheddarCB);
        pineappleCB = findViewById(R.id.pineappleCB);
        provoloneCB = findViewById(R.id.provoloneCB);
        greenpepersCB = findViewById(R.id.greenpepersCB);
        beefCB = findViewById(R.id.beefCB);
        toppingCB = new CheckBox[]{chickenCB, pepperoniCB, hamCB, sausageCB,
                baconCB, mushroomsCB, onionsCB, jalapenoCB, cheddarCB,
                pineappleCB, provoloneCB, greenpepersCB, beefCB};
    }
    private void addToCart(@NonNull View itemView) {
        atcBTN.setOnClickListener(view -> {
            if (cur instanceof BuildYourOwn) {
                ArrayList<Topping> selectedToppings = iterateCBGroup(1);
                for (Topping i: selectedToppings) {
                    cur.add(i);
                }
                View temp = new View(this);
                ((BuildYourOwn) cur).setToppingPrice(cbClicked(temp));
            }
            MainActivity.pizzas.add(cur);
        });
    }


    }
