package com.learning.designpatterns.structural.decorator;

class DarkRoast extends Beverage {
    @Override
    public double cost() {
        return 3.45;
    }

    @Override
    public String description() {
        return "Dark Roast";
    }
}
