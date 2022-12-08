package com.project5.rupizzeriamobile;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Order class is essential in defining a set of pizza orders
 * It creates all the necessary attributes associated with
 * an order such as price
 * @author Santosh Maryala,Nandan Tadi
 */

public class Order implements Customizable{

    private ArrayList<Pizza> currentOrder;
    private double price;
    private DecimalFormat df = new DecimalFormat("#.##");
    public int orderNumber;

    /**
     * Default constructor to initialize currentOrder list of pizzas
     */
    public Order() {
        currentOrder = new ArrayList<>();
    }

    /**
     *  Constructor to initialize a copy of the pizza list for future use
     * @param order to be copied
     */
    public Order(Order order) {
        currentOrder = new ArrayList<>();
        currentOrder = (ArrayList<Pizza>) order.currentOrder.clone();
    }

    /**
     * Function to add a pizza into the existing order list
     * @param obj pizza to be added
     * @return boolean true if added successfully
     */
    @Override
    public boolean add(Object obj) {
        currentOrder.add((Pizza) obj);
        return true;
    }

    public void setOrderNumber(int orderNumber){
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber(){
        return this.orderNumber;
    }

    /**
     * Function to remove a pizza from the existing pizza list
     * @param obj pizza to be removed
     * @return boolean true if removed successfully
     */
    @Override
    public boolean remove(Object obj) {
        currentOrder.remove(obj);
        return true;
    }

    /**
     * Function to set the price of order total
     * @param orderTotal pirce to be set to
     */
    public void setPrice(double orderTotal) {
        this.price = orderTotal;
    }

    /**
     * Function to get the price of current order
     * @return double value of current price of order
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Function to get the list of pizzas
     * @return list pizzas in the current order
     */
    public ArrayList<Pizza> getCurrentOrder(){
        return this.currentOrder;
    }

    /**
     * toString method to help display order details and
     * pricing in currentOrder
     * @return String value built
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Order ID: " + orderNumber);
        str.append("\nOrder Total: $" + df.format(this.price));
        str.append("\nOrder Details:\n");
        int count = 1;
        for (Pizza i: currentOrder) {
            str.append("\n\t Item #" + count + ":\n"
                    + i.toString("\t\t"));
            count++;
        }
        return str.toString();
    }
}
