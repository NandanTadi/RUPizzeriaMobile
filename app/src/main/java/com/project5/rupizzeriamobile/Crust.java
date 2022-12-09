package com.project5.rupizzeriamobile;

/**
 * Crust enum class lists out all the available crusts
 * @author Santosh Maryala,Nandan Tadi
 */
public enum Crust {
    DEEP_DISH("DEEP DISH"),
    PAN("PAN"),
    STUFFED("STUFFED"),
    BROOKLYN("BROOKLYN"),
    THIN("THIN"),
    HAND_TOSSED("HAND TOSSED");

    private String crust;

    /**
     * Constructor to provide crust
     * @param crust specified Crust
     */
    Crust(String crust) {
        this.crust = crust;
    }

    /**
     * Gets the crust in string format
     * @return String crust selected
     */
    public String getCrust() {
        return crust;
    }

}