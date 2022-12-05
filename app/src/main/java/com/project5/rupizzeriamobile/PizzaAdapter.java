package com.project5.rupizzeriamobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.PizzaHolder> {
    private Context context; //need the context to inflate the layout
    private ArrayList<Pizza> pizzas; //need the data binding to each row of RecyclerView

    public PizzaAdapter(Context context, ArrayList<Pizza> pizzas) {
        this.context = context;
        this.pizzas = pizzas;
    }

    /**
     * This method will inflate the row layout for the items in the RecyclerView
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public PizzaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the row layout for the items
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pizza_row, parent, false);

        return new PizzaHolder(view);
    }

    /**
     * Assign data values for each row according to their "position" (index) when the item becomes
     * visible on the screen.
     * @param holder the instance of ItemsHolder
     * @param position the index of the item in the list of items
     */
    @Override
    public void onBindViewHolder(@NonNull PizzaHolder holder, int position) {
        //assign values for each row
        holder.pizza_name.setText(pizzas.get(position).getPizzaStyle());
        holder.pizza_toppings.setText(pizzas.get(position).getToppings().toString());
        holder.pizza_crust.setText(pizzas.get(position).getCrust().toString());
    }

    /**
     * Get the number of items in the ArrayList.
     * @return the number of items in the list.
     */
    public int getItemCount() {
        return pizzas.size(); //number of MenuItem in the array list.
    }


    public static class PizzaHolder extends RecyclerView.ViewHolder {
        private ImageView pizza_image;
        private Button pizza_button;
        private ConstraintLayout parentLayout;
        private TextView pizza_name, pizza_crust, pizza_toppings;

        public PizzaHolder(@NonNull View PizzaView) {
            super(PizzaView);
            pizza_name = itemView.findViewById(R.id.pizza_name);
            pizza_crust = itemView.findViewById(R.id.pizza_crust);
            pizza_toppings = itemView.findViewById(R.id.pizza_toppings);
            pizza_button = itemView.findViewById(R.id.pizza_view_btn);
            pizza_image = itemView.findViewById(R.id.pizza_image);
            parentLayout = itemView.findViewById(R.id.row_layout);
            setAddButtonOnClick(itemView); //register the onClicklistener for the button on each row.


            /* set onClickListener for the row layout,
             * clicking on a row will navigate to another Activity
             */
            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(PizzaView.getContext(), PizzaSelectedActivity.class);
                    intent.putExtra("ITEM", pizza_name.getText());
                    PizzaView.getContext().startActivity(intent);
                }
            });
        }
        /**
         * Set the onClickListener for the button on each row.
         * Clicking on the button will create an AlertDialog with the options of YES/NO.
         * @param pizzaView
         */
        private void setAddButtonOnClick(@NonNull View pizzaView) {
            pizza_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(pizzaView.getContext());
                    alert.setTitle("Add to order");
                    alert.setMessage(pizza_name.getText().toString());
                    //handle the "YES" click
                    alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(pizzaView.getContext(),
                                    pizza_name.getText().toString() + " added.", Toast.LENGTH_LONG).show();
                        }
                        //handle the "NO" click
                    }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(pizzaView.getContext(),
                                    pizza_name.getText().toString() + " not added.", Toast.LENGTH_LONG).show();
                        }
                    });
                    AlertDialog dialog = alert.create();
                    dialog.show();
                }
            });
        }
    }
}
