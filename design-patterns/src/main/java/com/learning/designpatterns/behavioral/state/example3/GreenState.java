package com.learning.designpatterns.behavioral.state.example3;

public class GreenState implements TrafficLightState{
    @Override
    public void changeState(TrafficLight light) {
        System.out.println("Green - go!");
        light.setState(new YellowState());
    }
}
