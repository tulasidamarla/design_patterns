package com.learning.designpatterns.behavioral.state.example1;

public class Test {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.pressHomeButton();
        phone.pressHomeButton();
        phone.pressPowerButton();
        phone.pressPowerButton();
        phone.pressPowerButton();
        phone.pressHomeButton();
        phone.pressHomeButton();
        phone.pressHomeButton();
    }
    
}
