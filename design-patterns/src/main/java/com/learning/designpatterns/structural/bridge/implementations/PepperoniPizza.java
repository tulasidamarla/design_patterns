package com.learning.designpatterns.structural.bridge.implementations;

public class PepperoniPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("Adding Sauce: " + sauce);
        System.out.println("Adding Toppings: " + toppings);
        System.out.println("Adding Pepperoni");
        System.out.println("Crust is: " + crust);
    }


}

