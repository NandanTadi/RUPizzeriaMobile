package com.project5.rupizzeriamobile;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Pizza class is essential in defining a pizza object
 * It creates all the necessary attributes associated with a pizza
 * @author Santosh Maryala,Nandan Tadi
 */

public abstract class Pizza implements Customizable {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;
    private ArrayList<Topping> toppingList = new ArrayList<>();
    private DecimalFormat df = new DecimalFormat("#.##");

    /**
     * Abstract price methods used in child classes
     */
    public abstract double price();


    /**
     * Constructor initializing pizza class
     * @param crust associated with specific pizza
     */
    public Pizza(Crust crust) {
        this.crust = crust;
        this.toppings = new ArrayList<>();
    }

    /**
     * Function to add a topping into the existing toppings list
     * @param obj topping to be added
     * @return boolean true if added successfully
     */
    @Override
    public boolean add(Object obj) {
        return toppings.add((Topping) obj);
    }

    /**
     * Function to remove a topping from the existing toppings list
     * @param obj topping to be removed
     * @return boolean true if removed successfully
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Topping) {
            return toppings.remove((Topping) obj);
        }
        return false;
    }

    /**
     * Resets the size of the pizza based off change
     * @param size to be set
     */
    public void setSize(Size size){
        this.size = size;
    }

    /**
     * Function to identify what style the pizza is based on crust
     * @return int 0 if chicago style, 1 if not
     */
    public String getPizzaStyle() {
        if (crust == Crust.DEEP_DISH || crust == Crust.STUFFED
                || crust == Crust.PAN) {
            return "Chicago Style";
        }
        return "New York Style";
    }

    /**
     * Function to identify the size of pizza
     * @return Size of selected pizza
     */
    public Size getSize(){
        return this.size;
    }


    /**
     * Function to identify the crust of pizza
     * @return Crust of selected pizza
     */
    public Crust getCrust(){
        return this.crust;
    }

    /**
     * Function to obtain all the toppings on current pizza
     * @return ArrayList of toppings
     */
    public ArrayList<Topping> getToppings(){
        for(Topping topping : toppings){
            toppingList.add(topping);
        }
        return toppingList;
    }

    /**
     * toString method to help display pizza details and
     * pricing in currentOrder
     * @param tab shortcut for inputting tabs
     * @return String value built
     */
    public String toString(String tab) {
        StringBuilder str = new StringBuilder();
        if (getPizzaStyle().equals("Chicago Style"))
            str.append(tab + "Chicago Style\t-\t");
        else
            str.append(tab + "New York Style\t-\t");
        str.append(this.crust);
        str.append("\n" + tab + "Toppings: " + toppings.toString());
        str.append("\n" + tab + "Price: $" + df.format(price()));
        return str.toString();
    }

}
