package com.learning.designpatterns.behavioral.state.example1;

public class ReadyState extends State{
    public ReadyState(Phone phone){
        super(phone);
    }

    @Override
    public void onHome(){
        System.out.println("on home screen and ready to use");
    }
 
    @Override 
    public void onPowerButton(){
        System.out.println("In display off and locked state");
        phone.setState(new OffState(phone));
    }
}