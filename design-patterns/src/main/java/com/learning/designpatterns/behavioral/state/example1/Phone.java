package com.learning.designpatterns.behavioral.state.example1;

public class Phone{
    private State state;

    Phone(){
        state = new OffState(this);
    }

    public void setState(State state){
        this.state = state;
    }

    public void pressPowerButton(){
        state.onPowerButton();
    }

    public void pressHomeButton(){
        state.onHome();
    }
}

