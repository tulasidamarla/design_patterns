package com.learning.designpatterns.creational.factorymethod;

public class Test {
    public static void main(String[] args) {
        var vegBurgerRestaurant = new VegBurgerRestaurant();
        vegBurgerRestaurant.orderBurger();

        var chickenBurgerRestaurant = new ChickenBurgerRestaurant();
        chickenBurgerRestaurant.orderBurger();

    }
}
