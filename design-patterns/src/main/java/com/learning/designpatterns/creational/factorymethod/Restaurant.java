package com.learning.designpatterns.creational.factorymethod;

import com.learning.designpatterns.creational.factorymethod.products.Burger;

public abstract class Restaurant {
    public Burger orderBurger(){
        var burger = createBurger();
        burger.prepare();
        return burger;
    }

    public abstract Burger createBurger();
}
