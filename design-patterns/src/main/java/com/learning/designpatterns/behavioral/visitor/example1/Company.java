package com.learning.designpatterns.behavioral.visitor.example1;

public class Company extends Client{
    private final int noOfEmployees;
    Company(String name, String address, String number, int noOfEmployees){
        super(name, address, number);
        this.noOfEmployees = noOfEmployees;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCompany(this);
    }
}

