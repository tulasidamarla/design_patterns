package com.learning.designpatterns.behavioral.visitor.example1;

public interface Visitor{
    void visitBank(Bank bank);
    void visitCompany(Company company);
    void visitResident(Resident resident);
}

