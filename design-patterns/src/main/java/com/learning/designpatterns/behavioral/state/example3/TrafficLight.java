package com.learning.designpatterns.behavioral.state.example3;

/**
 * Context
 */

public class TrafficLight {

    private TrafficLightState state;
    private TrafficLightState prevState;

    TrafficLight() {
        this.state = new RedState();
        this.prevState = null;
    }

    void setState(TrafficLightState state) {
        this.prevState = this.state;
        this.state = state;
    }

    TrafficLightState getPrevState() {
        return this.prevState;
    }

    void change() {
        this.state.changeState(this);
    }
}
