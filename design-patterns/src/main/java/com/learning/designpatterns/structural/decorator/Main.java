package com.learning.designpatterns.structural.decorator;

class Main {

    public static void main(String[] args) {
      Beverage beverage = new FoamDecorator(
        new CreamDecorator(new EspressoDecorator(new LightRoast()))
      );
      System.out.println(beverage.description()); // Light Roast, Espresso, Cream, Foam
      System.out.println(beverage.cost()); // 4.45
    }
  }
  