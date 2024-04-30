package com.learning.designpatterns.behavioral.state.example1;

public class LockedState extends State{
    public LockedState(Phone phone){
        super(phone);
    }

    @Override
    public void onHome(){
        System.out.println("on home screen and unlocked state");
        phone.setState(new ReadyState(phone));
    }
 
    @Override 
    public void onPowerButton(){
        System.out.println("In display off and locked state");
        phone.setState(new OffState(phone));
    }
}