package com.learning.designpatterns.structural.composite.products;

import com.learning.designpatterns.structural.composite.Box;

public abstract class Product implements Box {
    protected final String title;

    public double getPrice() {
        return price;
    }

    protected final double price;

    protected Product(String title, double price) {
        this.title = title;
        this.price = price;
    }
}
