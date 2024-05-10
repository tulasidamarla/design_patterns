package com.learning.designpatterns.creational.factorymethod.products;

public class VegBurger extends Burger{
    @Override
    public void prepare() {
        System.out.println("Preparing veg burger");
    }
}
