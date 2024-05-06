package com.learning.designpatterns.structural.bridge;

import com.learning.designpatterns.structural.bridge.abstractions.AmericanRestaurant;
import com.learning.designpatterns.structural.bridge.abstractions.ItalianRestaurant;
import com.learning.designpatterns.structural.bridge.abstractions.Restaurant;
import com.learning.designpatterns.structural.bridge.implementations.PepperoniPizza;
import com.learning.designpatterns.structural.bridge.implementations.VeggiePizza;


public class Test {

    /*
     * Video Reference: https://youtu.be/88kAIisOiYs
     */
    public static void main(String[] args) {

        Restaurant americanRestaurant = new AmericanRestaurant(new PepperoniPizza());
        americanRestaurant.deliver();

        System.out.println("==========================================");

        Restaurant italianRestaurant = new ItalianRestaurant(new VeggiePizza());
        italianRestaurant.deliver();

    }

}
