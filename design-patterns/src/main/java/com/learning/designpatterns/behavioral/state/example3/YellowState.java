package com.learning.designpatterns.behavioral.state.example3;

public class YellowState implements TrafficLightState{
    @Override
    public void changeState(TrafficLight light) {
        if (light.getPrevState() instanceof RedState) {
            System.out.println("Yellow (from Red to Green) - caution!");
            light.setState(new GreenState());
        } else {
            System.out.println("Yellow (from Green to Red) - caution!");
            light.setState(new RedState());
        }
    }
}
