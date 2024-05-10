package com.learning.designpatterns.creational.factorymethod.products;

public class ChickenBurger extends Burger{
    @Override
    public void prepare() {
        System.out.println("Preparing chicken burger");
    }
}
