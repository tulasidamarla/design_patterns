package com.learning.designpatterns.behavioral.state.example2;

public class Test {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.pressButton(); // Output: Please insert a coin first.

        vendingMachine.insertCoin(); // Output: Coin inserted.
        vendingMachine.pressButton(); // Output: Item dispensed.
    }
    
}
