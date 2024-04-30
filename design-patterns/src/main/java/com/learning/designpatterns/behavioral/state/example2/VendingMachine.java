package com.learning.designpatterns.behavioral.state.example2;

public class VendingMachine {
    private State state;

    public VendingMachine() {
        // Initial state is NoCoinState
        state = new NoCoinState(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    // Delegate state-specific behavior to the current state object
    public void insertCoin() {
        state.insertCoin();
    }

    public void pressButton() {
        state.pressButton();
    }

    // Other methods...
}
