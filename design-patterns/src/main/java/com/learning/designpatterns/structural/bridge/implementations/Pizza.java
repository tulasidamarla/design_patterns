package com.learning.designpatterns.structural.bridge.implementations;

public abstract class Pizza {

    protected String sauce;
    protected String toppings;
    protected String crust;

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public abstract void prepare();

}

