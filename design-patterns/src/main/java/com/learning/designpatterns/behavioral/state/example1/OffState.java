package com.learning.designpatterns.behavioral.state.example1;

public class OffState extends State{
    private Phone phone;
    public OffState(Phone phone){
        super(phone);
        this.phone = phone;
    }

    @Override
    public void onHome(){
        System.out.println("On home screen and locked");
        phone.setState(new LockedState(phone));
    }
 
    @Override 
    public void onPowerButton(){
        System.out.println("On home screen and locked");
        phone.setState(new LockedState(phone));
    }
}