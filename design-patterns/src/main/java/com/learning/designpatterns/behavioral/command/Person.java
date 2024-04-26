package com.learning.designpatterns.behavioral.command;

public class Person {

    public static void main(String[] args) {
        Television television = new Television();
        Command onCommand = new OnCommand(television);
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(onCommand);
        remoteControl.pressButton();
    }
    
}
