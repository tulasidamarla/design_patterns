package com.learning.designpatterns.behavioral.visitor.example1;

public class Resident extends Client{
    private String insuranceClass;
    Resident(String name, String address, String number, String insuranceClass){
        super(name, address, number);
        this.insuranceClass = insuranceClass;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitResident(this);
    }
}

