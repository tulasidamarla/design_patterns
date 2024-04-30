package com.learning.designpatterns.behavioral.state.example2;

public class HasCoinState implements State {
    private VendingMachine vendingMachine;

    public HasCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You have already inserted a coin.");
    }

    @Override
    public void pressButton() {
        System.out.println("Item dispensed.");
        // Change state to NoCoinState after dispensing the item
        vendingMachine.setState(new NoCoinState(vendingMachine));
    }
}

