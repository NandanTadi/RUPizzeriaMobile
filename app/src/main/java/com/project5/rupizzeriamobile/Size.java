package com.project5.rupizzeriamobile;

/**
 * Size enum class defines all the available sizes for pizzas
 * @author Santosh Maryala,Nandan Tadi
 */

public enum Size {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");
    private String size;

    /**
     * Constructor to initialize size variable
     * @param size initialized
     */
    Size(String size) {
        this.size = size;
    }
}