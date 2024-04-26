package com.learning.designpatterns.behavioral.command;

public class RemoteControl {

    private Command command;

    public Command geCommand(){
        return command;
    }

    public void setCommand(Command command){
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }
    
}
