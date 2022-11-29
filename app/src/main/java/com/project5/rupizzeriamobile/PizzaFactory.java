package com.project5.rupizzeriamobile;

/**
 * PizzaFactory class to call necessary function based on
 * what pizza is selected
 * @author Santosh Maryala,Nandan Tadi
 */

public interface PizzaFactory {
    Pizza createDeluxe();
    Pizza createMeatzza();
    Pizza createBBQChicken();
    Pizza createBuildYourOwn();
}
