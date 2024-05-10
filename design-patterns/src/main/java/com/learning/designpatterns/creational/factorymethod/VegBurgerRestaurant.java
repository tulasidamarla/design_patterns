package com.learning.designpatterns.creational.factorymethod;

import com.learning.designpatterns.creational.factorymethod.products.Burger;
import com.learning.designpatterns.creational.factorymethod.products.VegBurger;

public class VegBurgerRestaurant extends Restaurant{
    @Override
    public Burger createBurger() {
        return new VegBurger();
    }
}
