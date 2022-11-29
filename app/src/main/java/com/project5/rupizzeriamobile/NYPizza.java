package com.project5.rupizzeriamobile;

/**
 * NYPizza class is essential in defining specific pizzas associated
 * with the NY style
 * @author Santosh Maryala,Nandan Tadi
 */
public class NYPizza implements PizzaFactory{

    /**
     * Method to return a Deluxe pizza withe Brooklyn crust
     * since it is NY style pizza
     * @return Brooklyn deluxe pizza
     */
    @Override
    public Pizza createDeluxe() {
        return new Deluxe(Crust.BROOKLYN);
    }

    /**
     * Method to return a Meatzza pizza withe Hand Tossed crust
     * since it is NY style pizza
     * @return Hand tossed Meatzza pizza
     */
    @Override
    public Pizza createMeatzza() {
        return new Meatzza(Crust.HAND_TOSSED);
    }

    /**
     * Method to return a BBQ Chicken pizza withe Thin crust
     * since it is NY style pizza
     * @return Thin BBQ Chicken pizza
     */
    @Override
    public Pizza createBBQChicken() {
        return new BBQChicken(Crust.THIN);
    }

    /**
     * Method to return a Build your own pizza withe Hand tossed crust
     * since it is NY style pizza
     * @return Hand tossed Build your own pizza
     */
    @Override
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn(Crust.HAND_TOSSED);
    }
}
