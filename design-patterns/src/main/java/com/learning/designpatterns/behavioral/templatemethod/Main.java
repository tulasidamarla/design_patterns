package com.learning.designpatterns.behavioral.templatemethod;

public class Main {
    public static void main(String[] args) {
        System.out.println("Building wooden house:");
        HouseBuilder woodenHouseBuilder = new WoodenHouseBuilder();
        woodenHouseBuilder.buildHouse();

        System.out.println("\nBuilding brick house:");
        HouseBuilder brickHouseBuilder = new BrickHouseBuilder();
        brickHouseBuilder.buildHouse();
    }
}
