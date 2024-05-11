package com.learning.designpatterns.creational.prototype;

import com.learning.designpatterns.creational.prototype.Vehicle;

public class Car extends Vehicle {

    private final int topSpeed;

    public Car(String brand, String model, String color, int topSpeed) {
        super(brand, model, color);
        this.topSpeed = topSpeed;
    }

    private Car(Car car) {
        super(car);
        this.topSpeed = car.topSpeed;
    }

    @Override
    public Car clone() {
        return new Car(this);
    }

}

