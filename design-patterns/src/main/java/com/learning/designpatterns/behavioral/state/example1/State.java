package com.learning.designpatterns.behavioral.state.example1;

public abstract class State{
        protected Phone phone;
        public State(Phone phone){
            this.phone = phone;
        }
    
        abstract void onHome();
        abstract void onPowerButton();
}    
    

