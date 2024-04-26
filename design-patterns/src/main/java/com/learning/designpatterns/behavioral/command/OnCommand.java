package com.learning.designpatterns.behavioral.command;

public class OnCommand implements Command {

    private Television television;

    OnCommand(Television television){
        this.television = television;
    }

    @Override
    public void execute() {
        television.on();
    }
    
}
