package com.learning.designpatterns.structural.bridge.implementations;

public class VeggiePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("Adding Sauce: " + sauce);
        System.out.println("Adding Toppings: " + toppings);
        System.out.println("Adding Cheese");
        System.out.println("Crust is: " + crust);
    }

}

