package com.learning.designpatterns.structural.decorator;

class LightRoast extends Beverage {

    @Override
    public double cost() {
        return 3.45;
    }

    @Override
    public String description() {
        return "Light Roast";
    }
}
