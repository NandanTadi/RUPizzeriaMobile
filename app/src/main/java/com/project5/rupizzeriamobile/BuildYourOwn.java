package com.project5.rupizzeriamobile;

import java.text.DecimalFormat;

/**
 * BuildYourOwn class is essential is defining specific
 * instance of BuildYourOwn pizza
 * @author Santosh Maryala,Nandan Tadi
 */
public class BuildYourOwn extends Pizza {
    private static double PRICING_SMALL = 8.99;
    private static double PRICING_MEDIUM = 10.99;
    private static double PRICING_LARGE = 12.99;
    private double toppingPrice = 0.00;
    private static double ADDPRICE = 1.59;
    private DecimalFormat df = new DecimalFormat("#.##");

    /**
     * Constructor to initialize BuildYourOwn pizza and appropriate toppings
     * @param crust associated with the pizza crust
     */
    public BuildYourOwn(Crust crust){
        super(crust);
    }

    /**
     * Provides price amount of pizza pie based on size and class
     * @return double representation of pizza
     */
    @Override
    public double price() {
        if (getSize().toString() == "SMALL") {
            return PRICING_SMALL + toppingPrice;
        } else if (getSize().toString() == "MEDIUM") {
            return PRICING_MEDIUM + toppingPrice;
        } else {
            return Double.parseDouble(df.format(PRICING_LARGE +
                    toppingPrice));
        }
    }

    /**
     * Function to determine if and how much additional cost
     * there are for toppings
     * @param additionalToppingsPrice the additional cost for toppings
     */
    public void setToppingPrice(double additionalToppingsPrice) {
        this.toppingPrice = additionalToppingsPrice;
    }

    /**
     * Provides additional topping amount of BYO pizza pie
     * @param additionalToppings number of additional toppings over 7
     * @return double string representation of pizza cost
     */
    public String getAddPrice(int additionalToppings){
        return df.format(ADDPRICE * additionalToppings);
    }
}