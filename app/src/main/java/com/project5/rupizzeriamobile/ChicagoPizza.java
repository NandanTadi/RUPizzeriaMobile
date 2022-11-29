package com.project5.rupizzeriamobile;

/**
 * ChicagoPizza class is essential in defining specific pizzas associated
 * with the Chicago style
 * @author Santosh Maryala,Nandan Tadi
 */
public class ChicagoPizza implements PizzaFactory{

    /**
     * Method to return a Deluxe pizza withe Deep Dish crust
     * since it is Chicago style pizza
     * @return Deep dish deluxe pizza
     */
    @Override
    public Deluxe createDeluxe() {
        return new Deluxe(Crust.DEEP_DISH);
    }

    /**
     * Method to return a Meatzza pizza withe Stuffed crust
     * since it is Chicago style pizza
     * @return Stuffed Meatzza pizza
     */
    @Override
    public Meatzza createMeatzza() {
        return new Meatzza(Crust.STUFFED);
    }

    /**
     * Method to return a BBQ Chicken pizza withe Pan crust
     * since it is Chicago style pizza
     * @return Pan BBQ Chicken pizza
     */
    @Override
    public BBQChicken createBBQChicken() {
        return new BBQChicken(Crust.PAN);
    }

    /**
     * Method to return a Build your own pizza withe Pan crust
     * since it is Chicago style pizza
     * @return Pan Build your own pizza
     */
    @Override
    public BuildYourOwn createBuildYourOwn() {
        return new BuildYourOwn(Crust.PAN);
    }
}
