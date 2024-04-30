package com.learning.designpatterns.behavioral.state.example2;

public class NoCoinState implements State {
    private VendingMachine vendingMachine;

    public NoCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted.");
        vendingMachine.setState(new HasCoinState(vendingMachine));
    }

    @Override
    public void pressButton() {
        System.out.println("Please insert a coin first.");
    }
}
