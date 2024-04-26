package com.learning.designpatterns.behavioral.templatemethod;
class WoodenHouseBuilder extends HouseBuilder {
    @Override
    protected void buildFoundation() {
        System.out.println("Building foundation with wood");
    }

    @Override
    protected void buildWalls() {
        System.out.println("Building walls with wood");
    }

    @Override
    protected void buildRoof() {
        System.out.println("Building roof with wood");
    }

    @Override
    protected void furnishHouse() {
        System.out.println("Furnishing wooden house");
    }

    @Override
    protected void addExtra() {
        System.out.println("Adding wooden deck");
    }
}
