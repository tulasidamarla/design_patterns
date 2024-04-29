package com.learning.designpatterns.behavioral.visitor.example1;

public class Bank extends Client{
    private final int banchesInsured;
    Bank(String name, String address, String number, int banchesInsured){
        super(name, address, number);
        this.banchesInsured = banchesInsured;
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visitBank(this);
    }
}

