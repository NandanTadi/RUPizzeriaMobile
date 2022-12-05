package com.project5.rupizzeriamobile;

import java.util.Collection;

/**
 * Deluxe class is essential is defining specific
 * instance of Deluxe pizza
 * @author Santosh Maryala,Nandan Tadi
 */
public class Deluxe extends Pizza{
    private static Double PRICING_SMALL = 14.99;
    private static Double PRICING_MEDIUM = 16.99;
    private static Double PRICING_LARGE = 18.99;
    /**
     * Constructor to initialize Deluxe pizza and appropriate crust
     * @param crust associated with the pizza
     */
    public Deluxe(Crust crust) {
        super(crust);
        add(Topping.SAUSAGE);
        add(Topping.PEPPERONI);
        add(Topping.GREENPEPPERS);
        add(Topping.ONIONS);
        add(Topping.MUSHROOMS);
    }
    /**
     * Provides price amount of pizza pie based on size and class
     * @return double representation of pizza
     */
    @Override
    public double price() {
        if (getSize().toString() == "SMALL") {
            return PRICING_SMALL;
        } else if (getSize().toString() == "MEDIUM") {
            return PRICING_MEDIUM;
        } else {
            return PRICING_LARGE;
        }
    }
}