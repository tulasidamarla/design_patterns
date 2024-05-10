package com.learning.designpatterns.creational.factorymethod;

import com.learning.designpatterns.creational.factorymethod.products.Burger;
import com.learning.designpatterns.creational.factorymethod.products.ChickenBurger;
import com.learning.designpatterns.creational.factorymethod.products.VegBurger;

public class ChickenBurgerRestaurant extends Restaurant{
    @Override
    public Burger createBurger() {
        return new ChickenBurger();
    }
}
