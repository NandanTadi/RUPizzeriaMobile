package com.project5.rupizzeriamobile;

/**
 * Meatzza class is essential is defining specific instance of Meatzza pizza
 * @author Santosh Maryala,Nandan Tadi
 */

public class Meatzza extends Pizza {
    private static Double PRICING_SMALL= 15.99;
    private static Double PRICING_MEDIUM = 17.99;
    private static Double PRICING_LARGE = 19.99;

    /**
     * Constructor to initialize Meatzza pizza and appropriate toppings
     * @param crust associated with the pizza
     */
    public Meatzza(Crust crust) {
        super(crust);
        add(Topping.SAUSAGE);
        add(Topping.PEPPERONI);
        add(Topping.BEEF);
        add(Topping.HAM);
    }

    /**
     * Function to determine the price of the current pizza based on size
     * @return double price of pizza
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