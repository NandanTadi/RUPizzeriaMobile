package com.project5.rupizzeriamobile;

/**
 * BBQChicken class is essential is defining specific
 * instance of BBChicken pizza
 * @author Santosh Maryala,Nandan Tadi
 */
public class BBQChicken extends Pizza {
    private static Double PRICING_SMALL = 13.99;
    private static Double PRICING_MEDIUM = 15.99;
    private static Double PRICING_LARGE = 17.99;
    /**
     * Constructor to initialize BBQChicken pizza and appropriate toppings
     * @param crust associated with the pizza
     */
    public BBQChicken(Crust crust) {
        super(crust);
        add(Topping.BBQCHICKEN);
        add(Topping.GREENPEPPERS);
        add(Topping.PROVOLONE);
        add(Topping.CHEDDAR);
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