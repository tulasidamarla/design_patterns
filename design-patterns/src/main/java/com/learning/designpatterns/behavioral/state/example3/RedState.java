package com.learning.designpatterns.behavioral.state.example3;

public class RedState implements TrafficLightState{
    @Override
    public void changeState(TrafficLight light) {
        System.out.println("Red - Stop!");
        light.setState(new YellowState());
    }
}
