package com.project5.rupizzeriamobile;

/**
 * Topping enum class lists out all the available toppings
 * @author Santosh Maryala,Nandan Tadi
 */
public enum Topping {
    SAUSAGE("SAUSAGE"),
    PEPPERONI("PEPPERONI"),
    GREENPEPPERS("GREENPEPPERS"),
    ONIONS("ONIONS"),
    MUSHROOMS("MUSHROOMS"),
    BBQCHICKEN("BBQCHICKEN"),
    PROVOLONE("PROVOLONE"),
    CHEDDAR("CHEDDAR"),
    BEEF("BEEF"),
    HAM("HAM"),
    PINEAPPLE("PINEAPPLE"),
    BACON("BACON"),
    JALAPENO("JALAPENO");

    private String topping;

    /**
     * Constructor initailizng the topping
     * @param topping specified Topping
     */
    Topping(String topping) {
        this.topping = topping;
    }

    /**
     * Gets the topping in string format
     * @return String topping selected
     */
    public String getTopping(){
        return this.topping;
    }

}