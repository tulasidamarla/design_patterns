package com.learning.designpatterns.behavioral.templatemethod;
class BrickHouseBuilder extends HouseBuilder {
    @Override
    protected void buildFoundation() {
        System.out.println("Building foundation with bricks");
    }

    @Override
    protected void buildWalls() {
        System.out.println("Building walls with bricks");
    }

    @Override
    protected void buildRoof() {
        System.out.println("Building roof with tiles");
    }

    @Override
    protected void furnishHouse() {
        System.out.println("Furnishing brick house");
    }

    @Override
    protected boolean addExtraFeatures() {
        return false;
    }
}