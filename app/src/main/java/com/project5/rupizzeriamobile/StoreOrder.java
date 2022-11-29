package com.project5.rupizzeriamobile;

import java.util.HashMap;

/**
 * StoreOrder class initializes list of orders placed by users
 * @author Santosh Maryala,Nandan Tadi
 */

public class StoreOrder implements Customizable{
    protected HashMap<Integer, Order> storeOrders = new HashMap<>();
    private int count = 0;

    /**
     * Function to add an order into the hashmap with unique order ids
     * @param obj order to be added
     * @return boolean true if added successfully
     */
    @Override
    public boolean add(Object obj) {
        storeOrders.put(count, (Order) obj);
        count++;
        return true;
    }

    /**
     * Function to remove an order when order is canceled from the store end
     * @param obj order to be removed
     * @return boolean true if removed successfully
     */
    @Override
    public boolean remove(Object obj) {
        storeOrders.remove(obj);
        return true;
    }
}
