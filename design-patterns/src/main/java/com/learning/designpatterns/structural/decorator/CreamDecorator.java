package com.learning.designpatterns.structural.decorator;

class CreamDecorator extends BeverageDecorator {

    public CreamDecorator(Beverage beverage) {
      super(beverage);
    }
  
    @Override
    public double cost() {
      return 0.3 + beverage.cost();
    }
  
    @Override
    public String description() {
      return beverage.description() + ", Cream";
    }
  }
  